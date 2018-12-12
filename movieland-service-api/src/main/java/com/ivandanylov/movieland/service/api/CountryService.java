package com.ivandanylov.movieland.service.api;

import com.ivandanylov.movieland.entity.Country;

import java.util.List;
import java.util.stream.Collectors;

public interface CountryService {
    Country getById(int id);

    List<Country> getAll();

    default Country enrich(Country country) {
        return getById(country.getId());
    }

    default List<Country> enrich(List<Country> countries) {
        return countries.parallelStream().map(country -> enrich(country)).collect(Collectors.toList());
    }
}
