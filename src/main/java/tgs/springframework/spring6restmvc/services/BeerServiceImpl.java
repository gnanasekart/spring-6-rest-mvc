package tgs.springframework.spring6restmvc.services;

import lombok.extern.slf4j.Slf4j;
import tgs.springframework.spring6restmvc.model.BeerDTO;
import tgs.springframework.spring6restmvc.model.BeerStyleDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService{

    private Map<UUID, BeerDTO> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        BeerDTO beerDTO1 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Corona")
                .beerStyleDTO(BeerStyleDTO.LAGER)
                .upc("67890")
                .price(new BigDecimal("9.99"))
                .qtyOnHand(100)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerDTO beerDTO2 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy")
                .beerStyleDTO(BeerStyleDTO.GOSE)
                .upc("12345")
                .price(new BigDecimal("12.99"))
                .qtyOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerDTO beerDTO3 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Heineken")
                .beerStyleDTO(BeerStyleDTO.ALE)
                .upc("78901")
                .price(new BigDecimal("11.99"))
                .qtyOnHand(88)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beerDTO1.getId(), beerDTO1);
        beerMap.put(beerDTO2.getId(), beerDTO2);
        beerMap.put(beerDTO3.getId(), beerDTO3);
    }

    @Override
    public List<BeerDTO> listBeers() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID uuid) {
        log.debug("Get the Beer Id from service class"+ uuid.toString());
        return Optional.of(beerMap.get(uuid));
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
        BeerDTO savedBeerDTO = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName(beerDTO.getBeerName())
                .beerStyleDTO(beerDTO.getBeerStyleDTO())
                .upc(beerDTO.getUpc())
                .price(beerDTO.getPrice())
                .qtyOnHand(beerDTO.getQtyOnHand())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        beerMap.put(savedBeerDTO.getId(), savedBeerDTO);
        return savedBeerDTO;
    }

    @Override
    public void updateBeerById(UUID uuid, BeerDTO beerDTO) {
        BeerDTO existingBeerDTO = beerMap.get(uuid);

        existingBeerDTO.setBeerName(beerDTO.getBeerName());
        existingBeerDTO.setBeerStyleDTO(beerDTO.getBeerStyleDTO());
        existingBeerDTO.setUpc(beerDTO.getUpc());
        existingBeerDTO.setPrice(beerDTO.getPrice());
        existingBeerDTO.setQtyOnHand(beerDTO.getQtyOnHand());
        existingBeerDTO.setUpdateDate(LocalDateTime.now());
    }

    @Override
    public void deleteBeerById(UUID uuid) {
        beerMap.remove(uuid);
    }

    @Override
    public void patchBeerById(UUID uuid, BeerDTO beerDTO) {
        BeerDTO existing = beerMap.get(uuid);

        if (StringUtils.hasText(beerDTO.getBeerName())) {
            existing.setBeerName(beerDTO.getBeerName());
        }

        if (beerDTO.getBeerStyleDTO()!= null) {
            existing.setBeerStyleDTO(beerDTO.getBeerStyleDTO());
        }

        if (StringUtils.hasText(beerDTO.getUpc())) {
            existing.setUpc(beerDTO.getUpc());
        }

        if (beerDTO.getPrice()!= null) {
            existing.setPrice(beerDTO.getPrice());
        }

        if (beerDTO.getQtyOnHand()!= null) {
            existing.setQtyOnHand(beerDTO.getQtyOnHand());
        }
    }
}
