package com.citi.shanghai.training.dataAnalyst.dao;

import com.citi.shanghai.training.dataAnalyst.model.AggsByHour;

public interface AggsByHourMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aggsByHour
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aggsByHour
     *
     * @mbggenerated
     */
    int insert(AggsByHour record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aggsByHour
     *
     * @mbggenerated
     */
    int insertSelective(AggsByHour record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aggsByHour
     *
     * @mbggenerated
     */
    AggsByHour selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aggsByHour
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AggsByHour record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aggsByHour
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AggsByHour record);
}