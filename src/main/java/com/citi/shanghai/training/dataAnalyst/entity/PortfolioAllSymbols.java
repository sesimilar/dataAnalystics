package com.citi.shanghai.training.dataAnalyst.entity;

import com.citi.shanghai.training.dataAnalyst.model.Symbols;

import java.util.List;

/**
 * Created by Administrator on 8/13/2018.
 */
public class PortfolioAllSymbols {

    private Integer portfolioId;

    private String createDate;

    private String portfolioName;

    private List<Symbols> symbols;

    public Integer getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Integer portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public List<Symbols> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbols> symbols) {
        this.symbols = symbols;
    }
}
