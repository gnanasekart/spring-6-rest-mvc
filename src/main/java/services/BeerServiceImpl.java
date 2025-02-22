package services;

import model.Beer;
import model.BeerStyle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class BeerServiceImpl implements BeerService{


    @Override
    public Beer getBeerById(UUID uuid) {
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
