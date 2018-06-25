package com.inguarus;


import java.util.List;

public class StructurePB {

    private String date;
    private String bank;
    private String baseCurrency;
    private String baseCurrencyLit;
    private List<FeatureCourse> exchangeRate;

    public String getDate() {
        return date;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public List<FeatureCourse> getExchangeRate() {
        return exchangeRate;
    }


}
