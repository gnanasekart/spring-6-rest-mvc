package tgs.springframework.spring6restmvc.services;

import tgs.springframework.spring6restmvc.model.Beer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {

    List<Beer> listBeers();

    Optional<Beer> getBeerById(UUID uuid);

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID uuid, Beer beer);

    void deleteBeerById(UUID uuid);

    void patchBeerById(UUID uuid, Beer beer);
}
