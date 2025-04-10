package tgs.springframework.spring6restmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.*;
import tgs.springframework.spring6restmvc.model.BeerStyleDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Beer {
    @Id
    private UUID id;

    @Version
    private Integer version;

    private String beerName;
    private BeerStyleDTO beerStyleDTO;
    private String upc;
    private Integer qtyOnHand;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
