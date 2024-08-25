package com.hamza.stockfetcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StockFetcherApplication {

	private static final String filePath = "C:/Users/lenovo/Desktop/testFolder/testAll.csv";
	private static final String[] stockTypes = {"GOLDS:COM", "SI1:COM"};
	private static final String[] header = {"DATE", "GOLD", "DATE", "SILVER"};

	public static void main(String[] args) {
		SpringApplication.run(StockFetcherApplication.class, args);
		RestCall rest = new RestCall();

		List<List<PricePoint>> data = new ArrayList<>();

		for(String type: stockTypes) {
			data.add(rest.getStock(type).getPrices());
		}

		OpenCSVWriter.writeToCSV(data, header, filePath);

	}

}
