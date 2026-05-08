package com.ok_project1.peaklist.service;


import com.ok_project1.peaklist.client.OverpassResponse;
import com.ok_project1.peaklist.model.TatraPeak;
import com.ok_project1.peaklist.repository.TatraPeaksRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OverpassService {

        private final RestClient restClient;
        private final TatraPeaksRepository repository;

    public void fetchAndSavePeaks() {
        String query = "[out:json];node[\"natural\"=\"peak\"][\"name\"](49.0,19.5,49.4,20.5);out;";
        OverpassResponse response = restClient.get()
                .uri("?data=" + query)
                .retrieve()
                .body(OverpassResponse.class);

        List<TatraPeak> summits = response.getElements().stream()
                .map(overpassElement -> {
                    TatraPeak summit = new TatraPeak();
                    summit.setName(overpassElement.getTags().getName());
                    summit.setNamePL(overpassElement.getTags().getNamePl());
                    summit.setHeight(overpassElement.getTags().getElevation() != null ? Double.parseDouble(overpassElement.getTags().getElevation()) : null);
                    summit.setPeakType(overpassElement.getTags().getNatural());
                    summit.setLon(overpassElement.getLon());
                    summit.setLat(overpassElement.getLat());
                    return summit;

                }).toList();
        repository.deleteAll();
        repository.saveAll(summits);

    }
}
