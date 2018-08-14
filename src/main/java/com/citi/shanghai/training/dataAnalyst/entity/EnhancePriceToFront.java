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
