package com.hamza.stockfetcher;

import org.springframework.web.client.RestClient;

public class RestCall {

    private String uriBase = "https://api-business.asharqbusiness.com/api/currencies/chart-data/";
    private String duration = "/5years";
    private RestClient restClient = RestClient.create();

    public Stock getStock(String typeId) {

        return restClient.get()
                .uri(uriBase + typeId + duration)
                .retrieve().body(Stock.class);

    }

}
