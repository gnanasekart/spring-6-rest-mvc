package tgs.springframework.spring6restmvc.controller;


import lombok.RequiredArgsConstructor;
import tgs.springframework.spring6restmvc.model.Customer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tgs.springframework.spring6restmvc.services.CustomerService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomer(){
        //log.info("Request to fetch all customers");
        return customerService.listCustomer();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable UUID id){
        //log.info("Request to fetch customer by id: {}", id);
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody Customer customer){
        //log.info("Request to create new customer: {}", customer);
        Customer newCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + customer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity updateCustomer(@RequestBody Customer customer, @PathVariable UUID id){
        //log.info("Request to update customer by id: {}, new data: {}", id, customer);
         customerService.updateCustomer(customer, id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity deleteCustomer(@PathVariable UUID uuid){
       // log.info("Request to delete customer by id: {}", uuid);
        customerService.deleteCustomer(uuid);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @PatchMapping("{id}")
    public ResponseEntity patchCustomer(@RequestBody Customer customer, @PathVariable UUID id){
        //log.info("Request to patch update customer by id: {}, new data: {}", id, customer);
        customerService.patchCustomer(customer, id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
