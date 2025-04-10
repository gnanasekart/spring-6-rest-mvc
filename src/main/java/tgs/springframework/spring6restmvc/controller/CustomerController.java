package tgs.springframework.spring6restmvc.controller;


import lombok.RequiredArgsConstructor;
import tgs.springframework.spring6restmvc.model.CustomerDTO;
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
    public List<CustomerDTO> listCustomer(){
        //log.info("Request to fetch all customers");
        return customerService.listCustomer();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable UUID id){
        //log.info("Request to fetch customer by id: {}", id);
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDTO customerDTO){
        //log.info("Request to create new customer: {}", customer);
        CustomerDTO newCustomerDTO = customerService.saveNewCustomer(customerDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + customerDTO.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable UUID id){
        //log.info("Request to update customer by id: {}, new data: {}", id, customer);
         customerService.updateCustomer(customerDTO, id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity deleteCustomer(@PathVariable UUID uuid){
       // log.info("Request to delete customer by id: {}", uuid);
        customerService.deleteCustomer(uuid);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @PatchMapping("{id}")
    public ResponseEntity patchCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable UUID id){
        //log.info("Request to patch update customer by id: {}, new data: {}", id, customer);
        customerService.patchCustomer(customerDTO, id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
