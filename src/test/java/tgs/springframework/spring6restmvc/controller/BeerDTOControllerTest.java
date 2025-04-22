package tgs.springframework.spring6restmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tgs.springframework.spring6restmvc.model.BeerDTO;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BeerDTOControllerTest {

    @Autowired
    BeerController beerController;

    @Test
    void getBeerById() {
        BeerDTO beer = beerController.listBeers().getFirst(); // Get the first available beer
        BeerDTO foundBeer = beerController.getBeerById(beer.getId());
        assertThat(foundBeer).isNotNull();
    }
}