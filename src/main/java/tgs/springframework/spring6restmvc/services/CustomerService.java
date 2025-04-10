package tgs.springframework.spring6restmvc.services;

import tgs.springframework.spring6restmvc.model.CustomerDTO;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<CustomerDTO> listCustomer();

    CustomerDTO getCustomerById(UUID uuid);

    CustomerDTO saveNewCustomer(CustomerDTO customerDTO);

    void updateCustomer(CustomerDTO customerDTO, UUID id);

    void deleteCustomer(UUID uuid);

    void patchCustomer(CustomerDTO customerDTO, UUID id);
}
