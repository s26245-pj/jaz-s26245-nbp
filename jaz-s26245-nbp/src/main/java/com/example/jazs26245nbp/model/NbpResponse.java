package com.example.jazs26245nbp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class NbpResponse {
    private List<Rate> rates;

    @Data
    public static class Rate {
        @JsonProperty("data")
        private LocalDate data;

        @JsonProperty("cena")
        private double cena;
    }
}
