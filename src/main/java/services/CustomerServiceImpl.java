package services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

    public Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        customerMap = Map.of();

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("sekar")
                .phno("123456")
                .rewardPoints(BigDecimal.valueOf(23.11))
                .build();

        customerMap.put(customer1.getId(), customer1);
    }

    @Override
    public List<Customer> listCustomer() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID uuid) {
        return customerMap.get(uuid);
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        Customer newCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .customerName(customer.getCustomerName())
                .phno(customer.getPhno())
                .rewardPoints(customer.getRewardPoints())
                .build();

        customerMap.put(newCustomer.getId(), newCustomer);
        return newCustomer;
    }

    @Override
    public Customer updateCustomer(Customer customer, UUID id) {
        Customer existingCustomer = customerMap.get(id);
        if (existingCustomer!= null) {
            existingCustomer.setCustomerName(customer.getCustomerName());
            existingCustomer.setPhno(customer.getPhno());
            existingCustomer.setRewardPoints(customer.getRewardPoints());
        }
        customerMap.put(existingCustomer.getId(), existingCustomer);
        return existingCustomer;
    }
}
