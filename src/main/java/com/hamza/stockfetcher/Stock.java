package com.hamza.stockfetcher;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = StockDeserializer.class)
public class Stock {
    private List<PricePoint> prices;

    // Getters and Setters
    public List<PricePoint> getPrices() {
        return prices;
    }

    public void setPrices(List<PricePoint> prices) {
        this.prices = prices;
    }
}


