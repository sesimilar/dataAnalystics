package com.citi.shanghai.training.dataAnalyst.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 8/14/2018.
 */
public class Price {

    private String date;
    private double open;
    private double high;
    private double low;
    private double close;

    public double getIncreasePercentage() {
        return increasePercentage;
    }

    public void setIncreasePercentage(double increasePercentage) {
        this.increasePercentage = increasePercentage;
    }

    private double increasePercentage;

    private BigDecimal volume;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;

        Price price = (Price) o;

        if (Double.compare(price.getOpen(), getOpen()) != 0) return false;
        if (Double.compare(price.getHigh(), getHigh()) != 0) return false;
        if (Double.compare(price.getLow(), getLow()) != 0) return false;
        if (Double.compare(price.getClose(), getClose()) != 0) return false;
        if (Double.compare(price.getIncreasePercentage(), getIncreasePercentage()) != 0) return false;
        if (!getDate().equals(price.getDate())) return false;
        return getVolume().equals(price.getVolume());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getDate().hashCode();
        temp = Double.doubleToLongBits(getOpen());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getHigh());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLow());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getClose());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getIncreasePercentage());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getVolume().hashCode();
        return result;
    }
}
