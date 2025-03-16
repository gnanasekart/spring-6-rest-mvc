package tgs.springframework.spring6restmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tgs.springframework.spring6restmvc.model.Beer;
import tgs.springframework.spring6restmvc.services.BeerService;
import tgs.springframework.spring6restmvc.services.BeerServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

@SpringBootTest
class BeerControllerTest {

    @Autowired
    BeerController beerController;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    BeerService beerService;

    @Autowired
    MockMvc mvc;

    BeerServiceImpl beerServiceImpl;

    @BeforeEach
    void setUp() {
        beerServiceImpl = new BeerServiceImpl();
    }

    @Test
    void getBeerById() {
        System.out.println(beerController.getBeerById(UUID.randomUUID()));
    }

    @Test
    void testCreateNewBeer() throws Exception {
        Beer beer = new BeerServiceImpl().listBeers().getFirst();
        beer.setVersion(null);
        beer.setId(null);

        given(beerService.saveNewBeer(any(Beer.class))).willReturn(beerServiceImpl.listBeers().get(1));
        mvc.perform(post("/api/v1/beer")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(beer)))
                .andExpect(status().isCreated());
        //System.out.println(objectMapper.writeValueAsString(beer));
    }

    @Test
    void testDeleteBeers() throws Exception {
        Beer beer = beerServiceImpl.listBeers().getFirst();

        mvc.perform(delete("/api/v1/beer" + beer.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        ArgumentCaptor<UUID> uuidArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(beerService).deleteBeerById(uuidArgumentCaptor.capture());

        assertThat(beer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
    }


}