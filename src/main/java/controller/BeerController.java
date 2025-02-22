package controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Beer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import services.BeerService;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {
    private final BeerService beerService;

    @Qualifier("beerService")
    public Beer getBeerById(UUID uuid){
        log.debug("getBeerById from Controller");
        return beerService.getBeerById(uuid);
    }
}
