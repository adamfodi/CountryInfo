package com.adamfodi.app.repository;

import com.adamfodi.app.model.CountryCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountriesUsingCurrencyRepository extends JpaRepository<CountryCurrency, Long> {
    List<CountryCurrency> findCountriesUsingCurrenciesByCurrency(String currency);
}
