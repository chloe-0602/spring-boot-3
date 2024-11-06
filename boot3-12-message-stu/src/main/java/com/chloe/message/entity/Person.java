package com.chloe.message.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: Person
 * Package: com.chloe.message.entity
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/6 23:08
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Long id;
    private String name;
    private String email;
}
