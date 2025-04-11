package tgs.springframework.spring6restmvc.mappers;

import org.mapstruct.Mapper;
import tgs.springframework.spring6restmvc.entities.Customer;
import tgs.springframework.spring6restmvc.model.CustomerDTO;

@Mapper
public interface CustomerMapper {

     CustomerDTO customerToCustomerDTO(Customer customer);

     Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
