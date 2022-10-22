package com.zwc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc;

}
