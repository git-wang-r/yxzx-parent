package com.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.File;
import java.util.Date;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @Version
    @TableField(fill = FieldFill.INSERT)
    private int version;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

}
