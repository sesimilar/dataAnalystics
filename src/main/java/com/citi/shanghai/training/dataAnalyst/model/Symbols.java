package com.citi.shanghai.training.dataAnalyst.model;

public class Symbols {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column symbols.symbolID
     *
     * @mbggenerated
     */
    private Integer symbolid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column symbols.symbol
     *
     * @mbggenerated
     */
    private String symbol;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column symbols.companyName
     *
     * @mbggenerated
     */
    private String companyname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column symbols.symbolID
     *
     * @return the value of symbols.symbolID
     *
     * @mbggenerated
     */
    public Integer getSymbolid() {
        return symbolid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column symbols.symbolID
     *
     * @param symbolid the value for symbols.symbolID
     *
     * @mbggenerated
     */
    public void setSymbolid(Integer symbolid) {
        this.symbolid = symbolid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column symbols.symbol
     *
     * @return the value of symbols.symbol
     *
     * @mbggenerated
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column symbols.symbol
     *
     * @param symbol the value for symbols.symbol
     *
     * @mbggenerated
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column symbols.companyName
     *
     * @return the value of symbols.companyName
     *
     * @mbggenerated
     */
    public String getCompanyname() {
        return companyname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column symbols.companyName
     *
     * @param companyname the value for symbols.companyName
     *
     * @mbggenerated
     */
    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }
}