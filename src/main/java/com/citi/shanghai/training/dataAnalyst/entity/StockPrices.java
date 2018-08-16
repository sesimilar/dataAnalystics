package com.citi.shanghai.training.dataAnalyst.entity;

import java.util.List;

/**
 * Created by Administrator on 8/14/2018.
 */
public class StockPrices {
    private String symbol;
    private List<Price> prices;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<Price> getPrices() {

        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockPrices)) return false;

        StockPrices that = (StockPrices) o;

        if (!getSymbol().equals(that.getSymbol())) return false;
        return getPrices().equals(that.getPrices());
    }

    @Override
    public int hashCode() {
        int result = getSymbol().hashCode();
        result = 31 * result + getPrices().hashCode();
        return result;
    }
}
