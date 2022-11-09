package com.zwc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
   private String pname;
   private String page;
   private String gender;
   private String[] hobby;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date birthday;
   private List<Pet> pets;
}
