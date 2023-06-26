package com.example.jazs26245nbp.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class NbpResponse {

    private List<Rate> rates;

    @Data
    public static class Rate {
        private LocalDate data;
        private double cena;
    }
}
