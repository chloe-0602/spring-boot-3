package com.chloe.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: Person
 * Package: com.chloe.redis.entity
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/6 11:35
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private Long id;
    private String name;
    private Integer age;
}
