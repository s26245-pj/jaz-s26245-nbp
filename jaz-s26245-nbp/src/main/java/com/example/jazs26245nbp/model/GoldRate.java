package com.example.jazs26245nbp.model;

import com.example.jazs26245nbp.enums.Currency;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class GoldRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Currency gold;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime queryDateTime;
    private double rate;

}
