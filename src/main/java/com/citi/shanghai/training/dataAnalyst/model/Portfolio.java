package com.citi.shanghai.training.dataAnalyst.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Portfolio {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column portfolios.portfolioID
     *
     * @mbggenerated
     */
    @Id
    @GeneratedValue
    private Integer portfolioid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column portfolios.createDate
     *
     * @mbggenerated
     */
    private String createdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column portfolios.portfolioName
     *
     * @mbggenerated
     */
    private String portfolioname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column portfolios.userID
     *
     * @mbggenerated
     */
    private Integer userid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column portfolios.portfolioID
     *
     * @return the value of portfolios.portfolioID
     *
     * @mbggenerated
     */
    public Integer getPortfolioid() {
        return portfolioid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column portfolios.portfolioID
     *
     * @param portfolioid the value for portfolios.portfolioID
     *
     * @mbggenerated
     */
    public void setPortfolioid(Integer portfolioid) {
        this.portfolioid = portfolioid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column portfolios.createDate
     *
     * @return the value of portfolios.createDate
     *
     * @mbggenerated
     */
    public String getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column portfolios.createDate
     *
     * @param createdate the value for portfolios.createDate
     *
     * @mbggenerated
     */
    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column portfolios.portfolioName
     *
     * @return the value of portfolios.portfolioName
     *
     * @mbggenerated
     */
    public String getPortfolioname() {
        return portfolioname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column portfolios.portfolioName
     *
     * @param portfolioname the value for portfolios.portfolioName
     *
     * @mbggenerated
     */
    public void setPortfolioname(String portfolioname) {
        this.portfolioname = portfolioname == null ? null : portfolioname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column portfolios.userID
     *
     * @return the value of portfolios.userID
     *
     * @mbggenerated
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column portfolios.userID
     *
     * @param userid the value for portfolios.userID
     *
     * @mbggenerated
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}