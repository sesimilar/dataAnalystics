package com;

import com.alibaba.fastjson.JSON;
import com.citi.shanghai.training.dataAnalyst.model.User;
import com.citi.shanghai.training.dataAnalyst.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml"})
public class UserServiceImplTest {

    private static Logger logger = Logger.getLogger(UserServiceImplTest.class);
    @Resource
    UserService userService;

    @Test
    public void getUserById() {
        User user = userService.getUserById(1);
        logger.info(JSON.toJSONString(user));
    }
}