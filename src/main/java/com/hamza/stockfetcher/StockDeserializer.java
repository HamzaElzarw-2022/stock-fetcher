package com.hamza.stockfetcher;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockDeserializer extends JsonDeserializer<Stock> {

    @Override
    public Stock deserialize(JsonParser jsonParser, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode rootNode = jsonParser.getCodec().readTree(jsonParser);
        JsonNode priceNode = rootNode.path("data").path("price");

        List<PricePoint> priceList = new ArrayList<>();

        for (JsonNode priceEntry : priceNode) {
            long date = priceEntry.get(0).asLong();
            double price = priceEntry.get(1).asDouble();
            priceList.add(new PricePoint(date, price));
        }

        Stock stock = new Stock();
        stock.setPrices(priceList);

        return stock;
    }
}

