package com.example.jazs26245nbp.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class NbpResponse {
    private String number;
    private LocalDate date;
    private BigDecimal value;
    private List<Rate> rates;

    @Data
    public static class Rate {
        private String no;
        private String effectiveDate;
        private Double mid;
    }
}
