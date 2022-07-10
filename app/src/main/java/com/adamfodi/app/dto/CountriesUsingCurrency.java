package com.adamfodi.app.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class CountriesUsingCurrency {

    @ApiModelProperty(notes = "Map of country name and code pairs.")
    Map<String, String> countriesMap;
}
