package tgs.springframework.spring6restmvc.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tgs.springframework.spring6restmvc.repositories.BeerRepository;
import tgs.springframework.spring6restmvc.repositories.CustomerRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BootStrapDataTest {

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    CustomerRepository customerRepository;

    BootStrapData bootStrapData;
    @BeforeEach
    void setUp() {
     bootStrapData = new BootStrapData(beerRepository, customerRepository);
    }

    @Test
    void testRun() throws Exception {

        bootStrapData.run(null);
        assertEquals(3, beerRepository.count());
        assertEquals(3, customerRepository.count());
    }
}