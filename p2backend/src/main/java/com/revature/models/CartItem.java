package com.revature.models;
/*
cart_item_id(serial)(pk)
item_id(int)(fk)
cart_history_id(int)(fk)
quantity(int)(default 0)
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //Marks this Class as having representation in the Database (Has a Table)
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id", updatable = false)
    private int id;

    @ManyToOne //many cart items in one cart history
    @JoinColumn(name = "cart_history_id")
    private CartHistory cartHistory;


    @Column(name = "quantity")
    private int quantity;
}
