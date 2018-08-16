package com.citi.shanghai.training.dataAnalyst.entity;

import java.util.Arrays;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceToFront)) return false;

        PriceToFront that = (PriceToFront) o;

        if (!getSymbol().equals(that.getSymbol())) return false;
        return Arrays.deepEquals(getData(), that.getData());
    }

    @Override
    public int hashCode() {
        int result = getSymbol().hashCode();
        result = 31 * result + Arrays.deepHashCode(getData());
        return result;
    }
}
