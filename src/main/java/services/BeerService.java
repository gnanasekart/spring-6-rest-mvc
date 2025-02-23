package services;

import model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    List<Beer> listBeers();

    Beer getBeerById(UUID uuid);

    Beer saveNewBeer(Beer beer);
}
