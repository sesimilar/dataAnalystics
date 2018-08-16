package com;

import com.citi.shanghai.training.dataAnalyst.dao.UserMapper;
import com.citi.shanghai.training.dataAnalyst.model.User;
import com.citi.shanghai.training.dataAnalyst.service.UserService;
import com.citi.shanghai.training.dataAnalyst.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    UserService userService = new UserServiceImpl();

    @Mock
    UserMapper mapper;


    @Test
    public void getUserById() {

        User user = mock(User.class);

        when(mapper.selectByPrimaryKey(anyInt())).thenReturn(user);

        assertEquals(user,userService.getUserById(1));
        verify(mapper,times(1)).selectByPrimaryKey(1);
    }
}