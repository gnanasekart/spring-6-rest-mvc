package tgs.springframework.spring6restmvc.controller;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import tgs.springframework.spring6restmvc.model.BeerDTO;
import tgs.springframework.spring6restmvc.repositories.BeerRepository;

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