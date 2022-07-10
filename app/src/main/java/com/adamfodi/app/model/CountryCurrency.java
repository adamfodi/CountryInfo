package com.adamfodi.app.model;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CountriesCurrency")
public class CountryCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "countryName")
    private String country;

    @Column(name = "countryCode")
    private String code;

    @Column(name = "countryCurrencyxxx")
    private String currency;

    public CountryCurrency(String country, String code, String currency) {
        this.country = country;
        this.code = code;
        this.currency = currency;
    }
}
