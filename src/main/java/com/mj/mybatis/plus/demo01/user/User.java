package com.mj.mybatis.plus.demo01.user;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("tbl_user")
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    @EnumValue
    private UserType userType;

}
