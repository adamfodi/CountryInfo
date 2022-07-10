package com.adamfodi.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {

    public CountryISOCodeResponse getCountryISOCodeResponse(String countryName) {
        CountryISOCode countryISOCode = new CountryISOCode();
        countryISOCode.setSCountryName(countryName);

        return (CountryISOCodeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        countryISOCode,
                        new SoapActionCallback("http://www.oorsprong.org/websamples.countryinfo/CountryInfoServiceSoapType/CountryISOCodeRequest"));
    }

    public CountriesUsingCurrencyResponse getCountriesUsingCurrency(String currency) {
        CountriesUsingCurrency countriesUsingCurrency = new CountriesUsingCurrency();
        countriesUsingCurrency.setSISOCurrencyCode(currency);

        return (CountriesUsingCurrencyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        countriesUsingCurrency,
                        new SoapActionCallback("http://www.oorsprong.org/websamples.countryinfo/CountryInfoServiceSoapType/CountriesUsingCurrencyRequest"));
    }
}
