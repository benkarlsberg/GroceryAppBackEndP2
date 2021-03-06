package com.revature.models;
/*
cart_history_id(serial)(pk)
user_id(int)(fk)
cart_history_id(int) (fk)
date(date)(can be null) - Date is null if order not completed
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //Marks this Class as having representation in the Database (Has a Table)
@Table(name="cart_history")
public class CartHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_history_id") //PK
    private int id;

    @ManyToOne  //Many cart histories to one user
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "date")
    private String date;
}
