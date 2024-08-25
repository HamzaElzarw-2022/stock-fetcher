package com.hamza.stockfetcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StockFetcherApplication {

	private static final String filePath = "C:/Users/lenovo/Desktop/testFolder/stocks.csv";
	private static final String[] stockTypes = {"XB1:COM", "CO1:COM", "CL1:COM", "NG1:COM", "HO1:COM", "MO1:COM", "BAP1:COM", "JBO1:COM", "LN1:COM", "LCO1:COM", "LA1:COM", "HG1:COM", "GOLDS:COM", "GC1:COM", "PL1:COM", "XPDUSD:CUR", "SI1:COM", "XAG:CUR", "KC1:COM", "CC1:COM", "CT1:COM", "QW1:COM", "RR1:COM", "S%201:COM", "W%201:COM"};
	private static final String[] header = {"Date", "gasoline", "brent blend", "West Texas Intermediate", "Natural gas", "Heating gas", "carbon emissions", "Propane", "Steel", "Nickel", "Cobalt", "Aluminum", "copper", "Gold", "Gold Comex", "Platinum", "Palladium", "Silver", "Silver Dollar", "Coffee", "Cocoa", "Cotton", "Sugar", "Rice", "soybean", "Wheat"};


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
