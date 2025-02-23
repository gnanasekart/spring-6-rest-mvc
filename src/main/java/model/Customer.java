package model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class Customer {

    private UUID id;
    private String customerName;
    private String phno;
    private BigDecimal rewardPoints;
    private LocalDateTime createdDate;
    private LocalDateTime purchaseDate;
}
