package tgs.springframework.spring6restmvc.services;

import tgs.springframework.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> listCustomer();

    Customer getCustomerById(UUID uuid);

    Customer saveNewCustomer(Customer customer);

    void updateCustomer(Customer customer, UUID id);

    void deleteCustomer(UUID uuid);

    void patchCustomer(Customer customer, UUID id);
}
