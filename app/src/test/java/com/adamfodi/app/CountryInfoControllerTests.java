package com.adamfodi.app;

import com.adamfodi.app.controller.CountryInfoController;
import com.adamfodi.app.service.CountryInfoService;
import com.adamfodi.soap.SoapClient;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CountryInfoControllerTests {

    @Mock
    @Autowired
    CountryInfoService countryInfoService;

    @InjectMocks
    @Autowired
    CountryInfoController countryInfoController;

    @Test
    public void testISOCode() {
        System.out.println("test iso code");

        String hungaryISOCodeWithController = countryInfoController.getCountryISOCode("Hungary");
        System.out.println(hungaryISOCodeWithController);

//        when(countryInfoService.getCountryISOCode("Hungary")).thenReturn("HU");
        String hungaryISOCodeWithService = countryInfoService.getCountryISOCode("Hungary");
        String germanyISOCodeWithService = countryInfoService.getCountryISOCode("Germany");

        System.out.println(hungaryISOCodeWithService);
        System.out.println(germanyISOCodeWithService);

        // Test for getCountryISOCode method in the controller.

//        // The result of the call is predetermined in line 29. It won't call the service.
//        // Test should fail. Expected: "HUx, but was "HU".
          // Expected: isEqualTo() , Was: assertThat()
//        assertThat(countryInfoController.getCountryISOCode("Hungary")).isEqualTo("HUx");
//        // Test should pass.
//        assertThat(countryInfoController.getCountryISOCode("Hungary")).isEqualTo(hungaryISOCodeWithService);

        assertAll("Should return the countries ISO code",
                () -> assertEquals(hungaryISOCodeWithService, countryInfoController.getCountryISOCode("Hungary")),
                () -> assertEquals(germanyISOCodeWithService, countryInfoController.getCountryISOCode("Hungary"))
        );
    }
}
