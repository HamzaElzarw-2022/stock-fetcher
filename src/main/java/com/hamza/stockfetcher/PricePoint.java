package com.hamza.stockfetcher;

public class PricePoint {
    private long date;
    private double price;

    // Constructor
    public PricePoint(long date, double price) {
        this.date = date;
        this.price = price;
    }

    // Getters and Setters
    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PricePoint{" +
                "date=" + date +
                ", price=" + price +
                '}';
    }
}

