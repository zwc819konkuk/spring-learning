package com.zwc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Player implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private String nickname;
    private String photo;
    private String filetype;

}
