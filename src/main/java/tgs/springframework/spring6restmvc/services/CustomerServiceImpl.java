package tgs.springframework.spring6restmvc.services;

import tgs.springframework.spring6restmvc.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService{

    public Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        customerMap = new HashMap<UUID, Customer>();

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
    public void updateCustomer(Customer customer, UUID id) {
        Customer existingCustomer = customerMap.get(id);
        if (existingCustomer!= null) {
            existingCustomer.setCustomerName(customer.getCustomerName());
            existingCustomer.setPhno(customer.getPhno());
            existingCustomer.setRewardPoints(customer.getRewardPoints());
        }
    }

    @Override
    public void deleteCustomer(UUID uuid) {
        customerMap.remove(uuid);
    }

    @Override
    public void patchCustomer(Customer customer, UUID id) {

        Customer existingCustomer = customerMap.get(id);

        if(StringUtils.hasText(customer.getCustomerName())) {
            existingCustomer.setCustomerName(customer.getCustomerName());
        }

        if(StringUtils.hasText(customer.getPhno())) {
            existingCustomer.setPhno(customer.getPhno());
        }

        if(customer.getRewardPoints()!= null) {
            existingCustomer.setRewardPoints(customer.getRewardPoints());
        }
    }
}
