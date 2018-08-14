package com.citi.shanghai.training.dataAnalyst.entity;

/**
 * Created by Administrator on 8/14/2018.
 */
public class PriceToFront {
    private String symbol;
    private String[][] data;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }
}
