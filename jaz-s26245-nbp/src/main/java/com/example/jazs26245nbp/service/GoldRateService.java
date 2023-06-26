package com.example.jazs26245nbp.service;

import com.example.jazs26245nbp.enums.Currency;
import com.example.jazs26245nbp.model.GoldRate;
import com.example.jazs26245nbp.model.NbpResponse;
import com.example.jazs26245nbp.repository.GoldRateRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Tag(name = "Gold Service", description = "Service for GoldRate")
public class GoldRateService {

    private final String NBP_API_URL = "http://api.nbp.pl/api/cenyzlota/";

    private final RestTemplate restTemplate;
    private final GoldRateRepository goldRateRepository;

    public GoldRateService(RestTemplate restTemplate, GoldRateRepository goldRateRepository) {
        this.restTemplate = restTemplate;
        this.goldRateRepository = goldRateRepository;
    }


    public GoldRate getGoldRateInfo(LocalDate startDate, LocalDate endDate) {
        NbpResponse nbpApiResponse = restTemplate.getForObject(NBP_API_URL + startDate + "/" + endDate,
                NbpResponse.class);


        Double averageRate = calculateRate(nbpApiResponse.getRates());
        GoldRate goldRate = new GoldRate();
        goldRate.setGold(Currency.GOLD);
        goldRate.setStartDate(startDate);
        goldRate.setEndDate(endDate);
        goldRate.setRate(averageRate);

        LocalDateTime currentTime = LocalDateTime.now();
        goldRate.setQueryDateTime(currentTime);

        return goldRateRepository.save(goldRate);
    }

    private Double calculateRate(List<NbpResponse.Rate> rates) {
        if (rates.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (NbpResponse.Rate rate : rates) {
            sum += rate.getCena();
        }
        return sum / rates.size();
    }
}
