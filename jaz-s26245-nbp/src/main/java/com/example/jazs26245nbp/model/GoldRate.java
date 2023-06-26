package com.example.jazs26245nbp.model;

import com.example.jazs26245nbp.enums.Currency;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class GoldRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID of the gold rate")
    private long id;
    @Enumerated(EnumType.STRING)
    @Schema(description = "Type of currency")
    private Currency gold;
    @Schema(description = "Start date of gold rate ")
    private LocalDate startDate;
    @Schema(description = "End date of gold rate ")
    private LocalDate endDate;
    @Schema(description = "Query time")
    private LocalDateTime queryDateTime;
    @Schema(description = "Average rate of chosen time")
    private double rate;

}
