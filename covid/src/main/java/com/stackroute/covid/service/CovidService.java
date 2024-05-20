package com.stackroute.covid.service;

import com.stackroute.covid.modal.CovidStateAnalytics;
import com.stackroute.covid.modal.Total;
import com.stackroute.covid.modal.TotalMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidService {

    @Autowired
    RestTemplate restTemplate;

    public List<CovidStateAnalytics> getAllCovidInputs() {
        ParameterizedTypeReference<Map<String, TotalMap>> responseType =
                new ParameterizedTypeReference<>() {
                };
        RequestEntity<Void> request = RequestEntity.get("https://data.covid19india.org/v4/min/data.min.json")
                .accept(MediaType.APPLICATION_JSON).build();
        return prepareStateWiseData(restTemplate.exchange(request, responseType).getBody());
    }

    private List<CovidStateAnalytics> prepareStateWiseData(Map<String, TotalMap> data){
        List<CovidStateAnalytics> covidStateAnalyticsList = new ArrayList<>();
        return data.keySet().stream().map(state -> {
            Total total = data.get(state).getTotal();
            return new CovidStateAnalytics(state,total.getConfirmed(),total.getDeceased(),total.getRecovered(),
                    total.getTested(), total.getVaccinated1(), total.getVaccinated2());
        }).collect(Collectors.toList());
    }
}
