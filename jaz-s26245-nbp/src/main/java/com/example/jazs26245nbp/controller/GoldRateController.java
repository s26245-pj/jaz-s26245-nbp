package com.example.jazs26245nbp.controller;


import com.example.jazs26245nbp.model.GoldRate;
import com.example.jazs26245nbp.service.GoldRateService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/CurrencyRate")
public class GoldRateController {

    private final GoldRateService goldRateService;

    public GoldRateController(GoldRateService goldRateService) {
        this.goldRateService = goldRateService;
    }

    @GetMapping("/{code}/{startDate},{endDate}")
    @Operation(summary = "Get Currency Rate Information")
    public ResponseEntity<GoldRate> getGoldRateInfo (@PathVariable("code") String code,
                                                     @PathVariable("startDate") LocalDate startDate,
                                                     @PathVariable("endDate")LocalDate endDate) {
        return ResponseEntity.ok(goldRateService.getGoldRateInfo(code, startDate, endDate));
    }
}
