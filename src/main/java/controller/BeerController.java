package controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Beer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.BeerService;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
public class BeerController {
    private final BeerService beerService;

    @RequestMapping("/api/v1/beer")
    public List<Beer> listBeers(){
        return beerService.listBeers();
    }

    public Beer getBeerById(UUID uuid){
        log.debug("getBeerById from Controller");
        return beerService.getBeerById(uuid);
    }
}
