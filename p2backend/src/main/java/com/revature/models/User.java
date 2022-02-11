package com.revature.driver.models;
/*
    We are going to have use JPA's annotations to tell Spring what to
    with this Class and how to map it to our Database. It is an abstraction of Hibernate (ORM)
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //Marks this Class as having representation in the Database (Has a Table)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false)
    private int id;
    @Column
    private String username;
    @Column
    private String password;

}
