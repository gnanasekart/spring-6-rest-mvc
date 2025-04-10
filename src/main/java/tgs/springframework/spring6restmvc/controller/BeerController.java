package tgs.springframework.spring6restmvc.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tgs.springframework.spring6restmvc.model.BeerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tgs.springframework.spring6restmvc.services.BeerService;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    public static final String BEER_PATH = "/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{uuid}";

    @RequestMapping(method = RequestMethod.GET)
    //@GetMapping(value = BEER_PATH)
    public List<BeerDTO> listBeers(){
        return beerService.listBeers();
    }

    @RequestMapping(value = "{uuid}", method = RequestMethod.GET)
    //@GetMapping(value = BEER_PATH)
    public BeerDTO getBeerById(@PathVariable("uuid") UUID uuid){
        log.debug("getBeerById from Controller - 1234678");
        return beerService.getBeerById(uuid).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    //@PostMapping(BEER_PATH)
    public ResponseEntity handlePost(@RequestBody BeerDTO beerDTO){
        BeerDTO beerDTONew = beerService.saveNewBeer(beerDTO);
        HttpHeaders header = new HttpHeaders();
        header.add("Location", "/api/v1/beer/" + beerDTONew.getId().toString());
        return new ResponseEntity(header, HttpStatus.CREATED);
    }

    @PutMapping("{uuid}")
    public ResponseEntity updateById(@PathVariable("uuid") UUID uuid, @RequestBody BeerDTO beerDTO){
        beerService.updateBeerById(uuid, beerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //@DeleteMapping(BEER_PATH_ID)
    @DeleteMapping("{uuid}")
    public ResponseEntity deleteById(@PathVariable("uuid") UUID uuid){
        beerService.deleteBeerById(uuid);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("{uuid}")
    public ResponseEntity patchBeerById(@PathVariable("uuid") UUID uuid, @RequestBody BeerDTO beerDTO){
        beerService.patchBeerById(uuid, beerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
