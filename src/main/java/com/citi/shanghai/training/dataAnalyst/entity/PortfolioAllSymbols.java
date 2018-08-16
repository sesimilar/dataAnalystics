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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PortfolioAllSymbols)) return false;

        PortfolioAllSymbols that = (PortfolioAllSymbols) o;

        if (getPortfolioId() != null ? !getPortfolioId().equals(that.getPortfolioId()) : that.getPortfolioId() != null)
            return false;
        if (getCreateDate() != null ? !getCreateDate().equals(that.getCreateDate()) : that.getCreateDate() != null)
            return false;
        if (getPortfolioName() != null ? !getPortfolioName().equals(that.getPortfolioName()) : that.getPortfolioName() != null)
            return false;
        return getSymbols() != null ? getSymbols().equals(that.getSymbols()) : that.getSymbols() == null;
    }

    @Override
    public int hashCode() {
        int result = getPortfolioId() != null ? getPortfolioId().hashCode() : 0;
        result = 31 * result + (getCreateDate() != null ? getCreateDate().hashCode() : 0);
        result = 31 * result + (getPortfolioName() != null ? getPortfolioName().hashCode() : 0);
        result = 31 * result + (getSymbols() != null ? getSymbols().hashCode() : 0);
        return result;
    }
}
