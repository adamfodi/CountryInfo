package com.adamfodi.app.service;

import com.adamfodi.app.dto.CountriesUsingCurrency;
import com.adamfodi.app.model.CountryCurrency;
import com.adamfodi.app.repository.CountriesUsingCurrencyRepository;
import com.adamfodi.soap.SoapClient;
import com.adamfodi.soap.TCountryCodeAndName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryInfoService {

    private final SoapClient soapClient;
    private final CountriesUsingCurrencyRepository countriesUsingCurrencyRepository;

    public String getCountryISOCode(String country) {
        System.out.println("CountryISOCode service called!");
        return soapClient.getCountryISOCodeResponse(country).getCountryISOCodeResult();
    }

    public CountriesUsingCurrency getCountriesUsingCurrency(String currency) {
        List<TCountryCodeAndName> tCountryCodeAndName = soapClient.getCountriesUsingCurrency(currency).getCountriesUsingCurrencyResult().getTCountryCodeAndName();

//        HashMap<String,String> countriesMap = new HashMap<>();
//        tCountryCodeAndName.forEach(c -> countriesMap.put(c.getSName(),c.getSISOCode()));

//        Map<String, String> countriesMap = tCountryCodeAndName.stream().collect(Collectors.toMap(c -> c.getSName(), c -> c.getSISOCode()));
        Map<String, String> countriesMap = tCountryCodeAndName.stream().collect(Collectors.toMap(TCountryCodeAndName::getSName, TCountryCodeAndName::getSISOCode));

        List<CountryCurrency> countryCurrencyList = countriesMap.entrySet().stream().map(c -> new CountryCurrency(c.getKey(), c.getValue(), currency)).collect(Collectors.toList());
        countriesUsingCurrencyRepository.saveAll(countryCurrencyList);

        return CountriesUsingCurrency
                .builder()
                .countriesMap(countriesMap)
                .build();
    }
}
