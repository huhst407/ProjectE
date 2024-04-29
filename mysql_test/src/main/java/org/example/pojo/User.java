package org.example.pojo;

import lombok.*;

@Data
@NoArgsConstructor //无参构造
@AllArgsConstructor //全参构造
public class User {
    private Integer id;
    private String name;
    private Short age;
    private Short gender;
    private String phone;
}
