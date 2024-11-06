package com.chloe.curd.crud.entity;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String empName;
    private Integer age;
    private String email;
}
