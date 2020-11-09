package com.rcmcode.countryservice.core;

import com.rcmcode.countryservice.model.external.CountryInfo;
import com.rcmcode.countryservice.model.internal.Country;
import com.rcmcode.countryservice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryMapper {

    @Autowired
    private CountryService countryService;

    public List<Country> fetchAllCountries() {
        List<CountryInfo> infos = countryService.findAllCountries();
        return infos
            .stream()
            .map(this::transformToReponse)
            .collect(Collectors.toList());
    }

    public Country fetchCountryByName(String name) {
        List<CountryInfo> infos = countryService.findCountryByName(name);
        return transformToReponse(infos.get(0));
    }

    private Country transformToReponse(CountryInfo countryInfo) {
        Country country = null;
        if (countryInfo != null) {
            country = new Country();
            country.setName(countryInfo.getName());
            country.setAlpha2Code(countryInfo.getAlpha2Code());
            country.setCapital(countryInfo.getCapital());
            country.setPopulation(countryInfo.getPopulation());
            country.setFlag(countryInfo.getFlag());
        }
        return country;
    }
}
