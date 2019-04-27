package com.mj.mybatis.plus.demo01.user;

import com.mj.mybatis.plus.demo01.user.mapper.UserMapper;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void shouldGetAllUsers() {
        final List<User> users = userMapper.selectList(null);
        assertThat(5, is(users.size()));
        users.forEach(System.out::println);
    }

    @Test
    public void shouldInsertOneUserSuccess() {
        userMapper.deleteById(10L);
        User user = new User(10L, "test01", 20, "test01@test.com",UserType.STUDENT);
        userMapper.insert(user);
        final User savedUser = userMapper.selectById(10L);
        assertThat(savedUser.getName(),is("test01"));
        assertThat(savedUser.getUserType(),is(UserType.STUDENT));
    }

    @Test
    public void shouldUpdateUserNameFromTest01ToTest02Success() {
        shouldInsertOneUserSuccess();
        final User savedUser = userMapper.selectById(10L);
        savedUser.setName("test02");
        savedUser.setUserType(UserType.TEACHER);
        userMapper.updateById(savedUser);
        assertThat(savedUser.getName(),is("test02"));
        assertThat(savedUser.getUserType(),is(UserType.TEACHER));
    }

}