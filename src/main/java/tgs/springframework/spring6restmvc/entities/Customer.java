package tgs.springframework.spring6restmvc.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.*;
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
    private UUID id;
    private String customerName;
    private String phno;

    @Version
    private Integer version;
    private BigDecimal rewardPoints;
    private LocalDateTime createdDate;
    private LocalDateTime purchaseDate;
}
