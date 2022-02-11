package com.revature.models;
/*
shopping_cart_id(serial)(pk)
user_id(int)(fk)
date(date)(can be null) - Date is null if order not completed
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //Marks this Class as having representation in the Database (Has a Table)
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sc_id", updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "u_id_fk")
    private User user;

    @Column(name = "date")
    private long date;
}
