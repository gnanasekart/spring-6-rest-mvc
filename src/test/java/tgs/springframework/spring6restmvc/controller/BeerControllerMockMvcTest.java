package tgs.springframework.spring6restmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tgs.springframework.spring6restmvc.model.Beer;
import tgs.springframework.spring6restmvc.services.BeerService;
import tgs.springframework.spring6restmvc.services.BeerServiceImpl;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
public class BeerControllerMockMvcTest {

    @Autowired
    MockMvc mvc;

    BeerServiceImpl beerServiceImpl = new BeerServiceImpl();

    @MockitoBean
    BeerService beerService;

    @Test
    void getBeerById() throws Exception {
        Beer testBeer = beerServiceImpl.listBeers().getFirst();

        given(beerService.getBeerById(any(UUID.class))).willReturn(testBeer);

        mvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
