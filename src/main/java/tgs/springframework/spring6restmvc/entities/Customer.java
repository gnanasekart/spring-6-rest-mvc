package tgs.springframework.spring6restmvc.entities;

import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    //@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator") - Deprecated
    @UuidGenerator
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;
    private String customerName;
    private String phno;

    @Version
    private Integer version;
    private BigDecimal rewardPoints;
    private LocalDateTime createdDate;
    private LocalDateTime purchaseDate;
}
