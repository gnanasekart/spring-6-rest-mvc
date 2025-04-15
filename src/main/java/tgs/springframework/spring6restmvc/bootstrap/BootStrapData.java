package tgs.springframework.spring6restmvc.bootstrap;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tgs.springframework.spring6restmvc.entities.Beer;
import tgs.springframework.spring6restmvc.entities.Customer;
import tgs.springframework.spring6restmvc.model.BeerStyleDTO;
import tgs.springframework.spring6restmvc.repositories.BeerRepository;
import tgs.springframework.spring6restmvc.repositories.CustomerRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

@Component
@AllArgsConstructor
public class BootStrapData implements CommandLineRunner {

    public final BeerRepository beerRepository;
    public final CustomerRepository customerRepository;

    public void run(String... args) throws Exception {

        loadBeerData();
        loadCustomerData();
    }
    private void loadBeerData() {
        if (beerRepository.count() == 0) {
            Beer beer1 = Beer.builder()
                    //.id(UUID.randomUUID())
                    //from spring 3.4.0, hibernate detects that some updated or deleted by another transaction is detected.
                    .beerName("Beer 1")
                    .beerStyleDTO(BeerStyleDTO.LAGER)
                    .upc("123456789012")
                    .qtyOnHand(12)
                    .price(new BigDecimal("12.99"))
                    .build();

            Beer beer2 = Beer.builder()
                    .beerName("Beer 2")
                    //.id(UUID.randomUUID())
                    .beerStyleDTO(BeerStyleDTO.IPA)
                    .upc("123456789013")
                    .qtyOnHand(10)
                    .price(new BigDecimal("15.99"))
                    .build();

            Beer beer3 = Beer.builder()
                    //.id(UUID.randomUUID())
                    .beerName("Beer 3")
                    .beerStyleDTO(BeerStyleDTO.STOUT)
                    .upc("123456789014")
                    .qtyOnHand(8)
                    .price(new BigDecimal("18.99"))
                    .build();

            beerRepository.save(beer1);
            beerRepository.save(beer2);
            beerRepository.save(beer3);
        }
    }
    private void loadCustomerData() {

        if (customerRepository.count() == 0) {
            Customer customer1 = Customer.builder()
                    .customerName("Customer 1")
                    .phno("1234567890")
                    .rewardPoints(BigDecimal.valueOf(100))
                    .build();

            Customer customer2 = Customer.builder()
                    .customerName("Customer 2")
                    .phno("0987654321")
                    .rewardPoints(BigDecimal.valueOf(200))
                    .build();

            Customer customer3 = Customer.builder()
                    .customerName("Customer 3")
                    .phno("1122334455")
                    .rewardPoints(BigDecimal.valueOf(300))
                    .build();

            customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));

        }
    }
}
