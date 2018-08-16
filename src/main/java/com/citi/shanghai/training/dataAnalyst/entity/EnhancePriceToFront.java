package com.citi.shanghai.training.dataAnalyst.entity;

import java.util.List;

/**
 * Created by Administrator on 8/14/2018.
 */
public class EnhancePriceToFront {
    private String err;
    private List<PriceToFront> result;

    public List<PriceToFront> getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnhancePriceToFront)) return false;

        EnhancePriceToFront that = (EnhancePriceToFront) o;

        if (getErr() != null ? !getErr().equals(that.getErr()) : that.getErr() != null) return false;
        return getResult().equals(that.getResult());
    }

    @Override
    public int hashCode() {
        int result1 = getErr() != null ? getErr().hashCode() : 0;
        result1 = 31 * result1 + getResult().hashCode();
        return result1;
    }

    public void setResult(List<PriceToFront> result) {
        this.result = result;
    }

    public String getErr() {

        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
