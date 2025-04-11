package tgs.springframework.spring6restmvc.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tgs.springframework.spring6restmvc.entities.Customer;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testSaveCustomer() {
        Customer customer = Customer.builder()
                .customerName("John")
                .build();

        Customer savedCustomer = customerRepository.save(customer);

        assertNotNull(savedCustomer);
        assertNotNull(savedCustomer.getId());
        assertEquals("John", savedCustomer.getCustomerName());
    }
}