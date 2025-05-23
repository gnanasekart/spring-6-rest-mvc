package tgs.springframework.spring6restmvc.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tgs.springframework.spring6restmvc.mappers.CustomerMapper;
import tgs.springframework.spring6restmvc.model.CustomerDTO;
import tgs.springframework.spring6restmvc.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> listCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .toList();
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID uuid) {
        return Optional.ofNullable(customerMapper.customerToCustomerDTO(customerRepository.findById(uuid)
                .orElse(null)));
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO, UUID id) {

    }

    @Override
    public void deleteCustomer(UUID uuid) {

    }

    @Override
    public void patchCustomer(CustomerDTO customerDTO, UUID id) {

    }
}
