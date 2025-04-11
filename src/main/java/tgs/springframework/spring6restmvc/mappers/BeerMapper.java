package tgs.springframework.spring6restmvc.mappers;

import org.mapstruct.Mapper;
import tgs.springframework.spring6restmvc.entities.Beer;
import tgs.springframework.spring6restmvc.model.BeerDTO;

@Mapper
public interface BeerMapper {

    BeerDTO beerToBeerDTO(Beer beer);

    Beer beerDTOToBeer(BeerDTO beerDTO);
}
