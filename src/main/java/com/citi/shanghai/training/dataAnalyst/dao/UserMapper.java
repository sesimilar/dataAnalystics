package com.citi.shanghai.training.dataAnalyst.dao;

import com.citi.shanghai.training.dataAnalyst.model.User;
import org.apache.ibatis.annotations.Param;
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    User selectByPrimaryKey(Integer userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(User record);
    int register(@Param("username") String username,@Param("password") String password);
    User login(@Param("username") String username, @Param("password") String password);

}