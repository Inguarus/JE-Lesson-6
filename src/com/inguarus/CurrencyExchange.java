package com.inguarus;

import com.google.gson.Gson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CurrencyExchange {

    public static final String DATE_FORMATTER = "dd.MM.yyyy";

    public static void main(String[] args) {

        String enteredDate = enterDate();
        String urlAPI = "https://api.privatbank.ua/p24api/exchange_rates?json&date=";
        String url = urlAPI + enteredDate;
        String result = HttpUtil.sendRequest(url);

        Gson gson = new Gson();
        StructurePB currency = gson.fromJson(result, StructurePB.class);
        if (currency.getExchangeRate().size() == 0) {
            System.out.println("Upon this date information about the course of currencies is absent, check the correctness of the input.");
        } else {
            for (int i = 0; i < currency.getExchangeRate().size(); i++) {
                if (currency.getExchangeRate().get(i).getCurrency().equals("USD")) {
                    System.out.println("The dollar exchange rate for this date is: " + String.valueOf(currency.getExchangeRate().get(i).getSaleRateNB()) + " grn");
                }
            }
        }
    }

    private static String enterDate() {

        System.out.println("Enter the date in this format dd.MM.YYYY:");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String date = scanner.nextLine();
            if (date.isEmpty()) {
                continue;
            }
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
                LocalDate parse = LocalDate.parse(date, formatter);
                return parse.format(formatter);
            } catch (Exception ex) {
                System.out.println("You entered an invalid date format, try again:");
                return enterDate();
            }
        }
        return enterDate();
    }
}