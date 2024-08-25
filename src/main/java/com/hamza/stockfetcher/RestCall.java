package com.hamza.stockfetcher;

import org.springframework.web.client.RestClient;

public class RestCall {

    private final String uriBase = "https://api-business.asharqbusiness.com/api/currencies/chart-data/";
    private final String duration = "/5years";
    private final RestClient restClient = RestClient.create();

    public Stock getStock(String typeId) {

        System.out.println("fetching " + typeId + " stock prices...");

        Stock stock = restClient.get()
                .uri(uriBase + typeId + duration)
                .retrieve().body(Stock.class);

        if(stock == null)
            System.out.println("fetched " + typeId +" NULL");
        else
            System.out.println("fetched " + typeId +" counts: "+ stock.getPrices().size());

        return stock;

    }

}
