package com.rcmcode.countryservice.service;

import com.rcmcode.countryservice.model.external.CountryInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface CountryServiceProxy {

    @GetMapping(value = "rest/v2/all")
    List<CountryInfo> retrieveAllCountries();

    @GetMapping(value = "rest/v2/name/{countryName}?fullText=true")
    List<CountryInfo> retrieveCountryByName(@PathVariable("countryName") String countryName);
}
