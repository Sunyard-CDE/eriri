package com.sunyard.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Churry
 * @create 2017-10-26 10:58
 **/
@Data
public class UserDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;
    private Integer age;

    public UserDTO(){

    }

    public UserDTO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
