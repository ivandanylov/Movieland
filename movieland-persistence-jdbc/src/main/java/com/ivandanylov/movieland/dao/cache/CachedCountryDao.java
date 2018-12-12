package com.ivandanylov.movieland.dao.cache;

import com.ivandanylov.movieland.dao.CountryDao;
import com.ivandanylov.movieland.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Primary
public class CachedCountryDao implements CountryDao {
    private CountryDao countryDao;
    private volatile Map<Integer, Country> countries = new HashMap<>();

    @PostConstruct
    @Scheduled(fixedDelayString = "${scheduler.countryFixedDelayInMilliseconds:14400000}",
            initialDelayString = "${scheduler.countryInitialDelayInMilliseconds:1000}")
    public void refresh() {
        HashMap<Integer, Country> countries = new HashMap<>();

        for (Country country : countryDao.getAll()) {
            countries.put(country.getId(), country);
        }

        this.countries = countries;
    }

    @Override
    public Country getById(int id) {
        return countries.get(id);
    }

    @Override
    public List<Country> getAll() {
        return new ArrayList<>(countries.values());
    }

    @Autowired
    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }
}
