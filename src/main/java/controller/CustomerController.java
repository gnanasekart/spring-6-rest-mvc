package controller;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Customer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CustomerService;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomer(){
        log.info("Request to fetch all customers");
        return customerService.listCustomer();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable UUID id){
        log.info("Request to fetch customer by id: {}", id);
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody Customer customer){
        log.info("Request to create new customer: {}", customer);
        Customer newCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + customer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }


}
