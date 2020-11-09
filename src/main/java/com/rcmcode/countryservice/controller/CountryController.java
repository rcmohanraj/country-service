package com.rcmcode.countryservice.controller;

import com.rcmcode.countryservice.core.CountryMapper;
import com.rcmcode.countryservice.model.internal.Countries;
import com.rcmcode.countryservice.model.internal.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "api/v1/countries")
public class CountryController {

    @Autowired
    private CountryMapper countryMapper;

    @GetMapping
    public ResponseEntity<Countries> getAllCountries() {
        List<Country> countryList = countryMapper.fetchAllCountries();
        Countries countries = new Countries();
        countries.setCountries(countryList);
        return ok(countries);
    }

    @GetMapping(value = "{name}")
    public ResponseEntity<Country> getCountryByName(@PathVariable("name") String name) {
        Country country = countryMapper.fetchCountryByName(name);
        return ok(country);
    }
}
