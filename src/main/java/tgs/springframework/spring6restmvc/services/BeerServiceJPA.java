package tgs.springframework.spring6restmvc.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tgs.springframework.spring6restmvc.mappers.BeerMapper;
import tgs.springframework.spring6restmvc.model.BeerDTO;
import tgs.springframework.spring6restmvc.repositories.BeerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class BeerServiceJPA implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public List<BeerDTO> listBeers() {
        return List.of();
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
        return null;
    }

    @Override
    public void updateBeerById(UUID uuid, BeerDTO beerDTO) {

    }

    @Override
    public void deleteBeerById(UUID uuid) {

    }

    @Override
    public void patchBeerById(UUID uuid, BeerDTO beerDTO) {

    }
}
