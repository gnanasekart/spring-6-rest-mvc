package tgs.springframework.spring6restmvc.services;

import tgs.springframework.spring6restmvc.model.CustomerDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService{

    public Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl() {
        customerMap = new HashMap<UUID, CustomerDTO>();

        CustomerDTO customerDTO1 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .customerName("sekar")
                .phno("123456")
                .rewardPoints(BigDecimal.valueOf(23.11))
                .build();

        customerMap.put(customerDTO1.getId(), customerDTO1);
    }

    @Override
    public List<CustomerDTO> listCustomer() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public CustomerDTO getCustomerById(UUID uuid) {
        return customerMap.get(uuid);
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
        CustomerDTO newCustomerDTO = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .customerName(customerDTO.getCustomerName())
                .phno(customerDTO.getPhno())
                .rewardPoints(customerDTO.getRewardPoints())
                .build();

        customerMap.put(newCustomerDTO.getId(), newCustomerDTO);
        return newCustomerDTO;
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO, UUID id) {
        CustomerDTO existingCustomerDTO = customerMap.get(id);
        if (existingCustomerDTO != null) {
            existingCustomerDTO.setCustomerName(customerDTO.getCustomerName());
            existingCustomerDTO.setPhno(customerDTO.getPhno());
            existingCustomerDTO.setRewardPoints(customerDTO.getRewardPoints());
        }
    }

    @Override
    public void deleteCustomer(UUID uuid) {
        customerMap.remove(uuid);
    }

    @Override
    public void patchCustomer(CustomerDTO customerDTO, UUID id) {

        CustomerDTO existingCustomerDTO = customerMap.get(id);

        if(StringUtils.hasText(customerDTO.getCustomerName())) {
            existingCustomerDTO.setCustomerName(customerDTO.getCustomerName());
        }

        if(StringUtils.hasText(customerDTO.getPhno())) {
            existingCustomerDTO.setPhno(customerDTO.getPhno());
        }

        if(customerDTO.getRewardPoints()!= null) {
            existingCustomerDTO.setRewardPoints(customerDTO.getRewardPoints());
        }
    }
}
