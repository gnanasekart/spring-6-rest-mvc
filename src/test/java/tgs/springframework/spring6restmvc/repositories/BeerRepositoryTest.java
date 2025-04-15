package tgs.springframework.spring6restmvc.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tgs.springframework.spring6restmvc.entities.Beer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveBeer() {
        Beer beer = Beer.builder()
                .beerName("Test Beer")
                .upc(String.valueOf(123456789012L))
                .price(new BigDecimal("12.99"))
                .createdDate(LocalDateTime.now())
                .build();

        Beer savedBeer = beerRepository.save(beer);

        assertNotNull(savedBeer);
        assertNotNull(savedBeer.getId());
        assertEquals("Test Beer", savedBeer.getBeerName());
    }

    @Test
    void testAlterBeer() {
        Beer beer = Beer.builder()
                .beerName("Test Beer")
                .upc(String.valueOf(123456789012L))
                .price(new BigDecimal("12.99"))
                .createdDate(LocalDateTime.now())
                .build();

        Beer savedBeer = beerRepository.save(beer);

        if (beerRepository.count() > 0 && beerRepository.findById(savedBeer.getId()).isPresent()) {
            savedBeer.setBeerName("Altered Beer");
            savedBeer.setPrice(new BigDecimal("15.99"));
            beerRepository.save(savedBeer);
        }

        assertNotNull(savedBeer);
        assertNotNull(savedBeer.getId());
        assertEquals("Altered Beer", savedBeer.getBeerName());
        assertEquals(new BigDecimal("15.99"), savedBeer.getPrice());
    }

}