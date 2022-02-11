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
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //Marks this Class as having representation in the Database (Has a Table)
public class CartHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_history_id", updatable = false) //PK
    private int id;

    @ManyToOne  //creates fk in user table
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne  //FK calls upon itself
    @JoinColumn(name = "cart_history_id")
    private CartItem CartHistoryId;

    @Column(name = "date")
    private long date;
}
