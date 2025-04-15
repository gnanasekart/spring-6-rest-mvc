package tgs.springframework.spring6restmvc.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
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
    @GeneratedValue(generator = "UUID")
    //@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator") - Deprecated
    @UuidGenerator
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
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
