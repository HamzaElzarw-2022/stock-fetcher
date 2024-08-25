package com.hamza.stockfetcher;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import java.text.SimpleDateFormat;


public class OpenCSVWriter {

    public static void writeToCSV(List<List<PricePoint>> data, String[] header, String filePath) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Write header
            writer.writeNext(header);

            // Write data
            for(int i=0; i<60; i++) {

                String[] res = new String[(data.size()*2)];
                int counter = 0;

                for(List<PricePoint> pointList : data) {
                    String formattedDate = dateFormat.format(new Date(pointList.get(i).getDate()));

                    res[counter] = formattedDate;
                    res[counter+1] = String.valueOf(pointList.get(i).getPrice());
                    counter = counter+2;

                }

                writer.writeNext(res);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

