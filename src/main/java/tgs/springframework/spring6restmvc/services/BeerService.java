package tgs.springframework.spring6restmvc.services;

import tgs.springframework.spring6restmvc.model.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {

    List<BeerDTO> listBeers();

    Optional<BeerDTO> getBeerById(UUID uuid);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    void updateBeerById(UUID uuid, BeerDTO beerDTO);

    void deleteBeerById(UUID uuid);

    void patchBeerById(UUID uuid, BeerDTO beerDTO);
}
