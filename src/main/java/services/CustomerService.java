package services;

import model.Beer;
import model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> listCustomer();

    Customer getCustomerById(UUID uuid);

    Customer saveNewCustomer(Customer customer);

    Customer updateCustomer(Customer customer, UUID id);
}
