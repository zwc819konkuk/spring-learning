package com.zwc.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("dept")
public class Dept implements Serializable {

    @TableField(exist = false)
    private String aaa;
    @TableField("deptno")
    private Integer deptno;
    private String dname;
    private String loc;
}
