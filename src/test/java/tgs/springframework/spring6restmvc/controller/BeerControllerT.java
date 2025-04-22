package tgs.springframework.spring6restmvc.controller;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import tgs.springframework.spring6restmvc.model.BeerDTO;
import tgs.springframework.spring6restmvc.repositories.BeerRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerControllerT {

    @Autowired
    BeerController beerController;

    @Autowired
    BeerRepository beerRepository;

    @Rollback
    @Transactional
    @Test
    void testCreateNewBeer() {
        BeerDTO beerDTO = BeerDTO.builder()
                .beerName("New Beer")
                .beerStyleDTO(null)
                .upc("123456789012")
                .qtyOnHand(10)
                .price(new BigDecimal("12.99"))
                .build();

        ResponseEntity responseEntity = beerController.handlePost(beerDTO);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

        String[] location = responseEntity.getHeaders().getLocation().getPath().split("/");

        UUID id = UUID.fromString(location[location.length - 1]);

        beerRepository.findById(id).ifPresent(beer -> {
            assertThat(beer).isNotNull();
            assertThat(beer.getBeerName()).isEqualTo("New Beer");
        });
    }

    @Test
    void getBeerById() {
        BeerDTO beerDTO = beerController.getBeerById(beerRepository.findAll().getFirst().getId());
        assertNotNull(beerDTO);
        assertEquals(beerRepository.findAll().getFirst().getId(), beerDTO.getId());
    }

    @Test
    void testGetBeerByIdNotFound() {
        assertThrows(NotFoundException.class, () -> beerController.getBeerById(UUID.randomUUID()));
    }

    @Test
    void testListBeers() {
        List<BeerDTO> listBeer = beerController.listBeers();
        assertNotNull(beerController.listBeers());
        assertThat(listBeer.size()).isEqualTo(3);
    }

    @Rollback
    @Transactional
    @Test
    void testEmptyBeers() {
        beerRepository.deleteAll();
        List<BeerDTO> listBeer = beerController.listBeers();
        assertNotNull(beerController.listBeers());
        assertThat(listBeer.size()).isEqualTo(0);
    }
}