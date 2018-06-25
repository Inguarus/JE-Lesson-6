package com.inguarus;

public class FeatureCourse {

    private String baseCurrency;
    private String currency;
    private double saleRateNB;
    private double purchaseRateNB;
    private double saleRate;
    private double purchaseRate;

    public double getSaleRate() {
        return saleRate;
    }

    public double getPurchaseRate() {
        return purchaseRate;
    }

    public String getCurrency() {
        return currency;
    }

    public double getSaleRateNB() {
        return saleRateNB;
    }

    public double getPurchaseRateNB() {
        return purchaseRateNB;
    }

}

