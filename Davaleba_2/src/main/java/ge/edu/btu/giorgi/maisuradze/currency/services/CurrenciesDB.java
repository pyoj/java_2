package ge.edu.btu.giorgi.maisuradze.currency.services;

import ge.edu.btu.giorgi.maisuradze.currency.models.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CurrenciesDB {

    // singleton pattern
    private static CurrenciesDB INSTANCE = null;

    private List<Currency> currencies;

    public static CurrenciesDB getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new CurrenciesDB();

            List<Currency> initCurrencies = new ArrayList<>();

            initCurrencies.add(new Currency("USD", 3.160, 3.200));
            initCurrencies.add(new Currency("EUR", 3.425, 3.475));
            initCurrencies.add(new Currency("GBP", 3.840, 3.940));
            initCurrencies.add(new Currency("RUB", 4.120, 4.250));
            initCurrencies.add(new Currency("TRY", 0.400, 0.470));
            initCurrencies.add(new Currency("AZN", 1.600, 1.840));

            INSTANCE.currencies = initCurrencies;
        }

        return INSTANCE;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public Currency getCurrencyByTitle(String title) {
        return currencies.stream().filter(
                c -> c.getTitle().equals(title)).collect(Collectors.toList()
        ).stream().findAny().orElse(null);
    }
}
