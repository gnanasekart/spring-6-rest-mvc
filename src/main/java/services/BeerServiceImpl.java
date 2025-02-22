package services;

import lombok.extern.slf4j.Slf4j;
import model.Beer;
import model.BeerStyle;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService{

    @Override
    public Beer getBeerById(UUID uuid) {
        log.debug("Get the Beer Id from service class"+ uuid.toString());
        return Beer.builder()
                .id(uuid)
                .version(1)
                .beerName("Galaxy")
                .beerStyle(BeerStyle.GOSE)
                .upc("12345")
                .price(new BigDecimal("12.99"))
                .qtyOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
