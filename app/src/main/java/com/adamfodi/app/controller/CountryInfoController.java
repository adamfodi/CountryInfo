package com.adamfodi.app.controller;

import com.adamfodi.app.dto.CountriesUsingCurrency;
import com.adamfodi.app.service.CountryInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CountryInfoController {

    private final CountryInfoService countryInfoService;

    @GetMapping(value = "/ISOCode")
    public String getCountryISOCode(@RequestParam String country) {
        System.out.println("CountryISOCode controller called!");
        return countryInfoService.getCountryISOCode(country);
    }

    @GetMapping(value = "/CountriesUsingCurrency", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Countries by input currency",
            notes = "Getting all countries that use the received currency.",
            response = CountriesUsingCurrency.class)
    public CountriesUsingCurrency getCountriesUsingCurrency(@RequestParam String currency) {
        System.out.println("CountriesUsingCurrency controller called!");
        return countryInfoService.getCountriesUsingCurrency(currency);
    }
}
