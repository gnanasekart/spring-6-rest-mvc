package tgs.springframework.spring6restmvc.controller;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import tgs.springframework.spring6restmvc.model.CustomerDTO;
import tgs.springframework.spring6restmvc.repositories.CustomerRepository;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerT {

    @Autowired
    CustomerController customerController;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void listCustomer() {
        List<CustomerDTO> listCustomer = customerController.listCustomer();
        assertNotNull(customerController.listCustomer());
        assertEquals(3, listCustomer.size());
    }

    @Test
    void getCustomerById() {
        CustomerDTO customerDTO = customerController.getCustomerById(customerRepository.findAll().getFirst().getId());
        assertNotNull(customerDTO);
        assertEquals(customerRepository.findAll().getFirst().getId(), customerDTO.getId());
    }

    @Test
    void testGetCustomerByIdNotFound() {
        assertThrows(NotFoundException.class, () -> customerController.getCustomerById(UUID.randomUUID()));
    }

    @Rollback
    @Transactional
    @Test
    void testListCustomerEmpty() {
        customerRepository.deleteAll();
        List<CustomerDTO> listCustomer = customerController.listCustomer();
        assertNotNull(customerController.listCustomer());
        assertEquals(0, listCustomer.size());
    }
}