package controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Beer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.BeerService;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers(){
        return beerService.listBeers();
    }

    @RequestMapping(value = "{uuid}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("uuid") UUID uuid){
        log.debug("getBeerById from Controller - 1234678");
        return beerService.getBeerById(uuid);
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody Beer beer){
        Beer beerNew = beerService.saveNewBeer(beer);

        HttpHeaders header = new HttpHeaders();
        header.add("Location", "/api/v1/beer/" + beerNew.getId().toString());

        return new ResponseEntity(header, HttpStatus.CREATED);
    }

    @PutMapping("{uuid}")
    public ResponseEntity updateById(@PathVariable("uuid") UUID uuid, @RequestBody Beer beer){

        beerService.updateBeerById(uuid, beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
