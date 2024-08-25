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

            System.out.println("Started writing data to file...");

            // Write data
            for(int i=0; i<data.get(0).size(); i++) {

                String[] res = new String[(data.size()+1)];

                String formattedDate = dateFormat.format(new Date(data.get(0).get(i).getDate()));
                res[0] = formattedDate;

                int counter = 1;

                for(List<PricePoint> pointList : data) {

                    res[counter] = String.valueOf(pointList.get(i).getPrice());
                    counter++;
                }

                writer.writeNext(res);
            }

            System.out.println("Data written to file successfully.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

