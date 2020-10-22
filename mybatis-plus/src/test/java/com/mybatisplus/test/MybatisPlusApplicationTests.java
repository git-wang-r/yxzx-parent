package com.mybatisplus.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatisplus.entity.User;
import com.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.sql.Wrapper;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    public void test1(){
/*
        List<User> users = userMapper.selectList(null);
*/
    /*    for (int i = 0; i <10 ; i++) {
            User user = userMapper.selectById(1);
            user.setName("123");
            user.setAge(223);

            int insert = userMapper.updateById(user);
        }*/


/*
        System.out.println(insert);
*/


      /*  List<User> userList = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));*/

       /* int i = userMapper.deleteById(1l);
        System.out.println(i);*/
      /*  QueryWrapper queryWrapper = new QueryWrapper();
*/
       /* int random = (int) (Math.random()*10);
        System.out.println(random);*/


    }
}
