package com.revature.models;
/*
cart_item_id(serial)(pk)
item_id(int)(fk)
shopping_cart_id(int)(fk)
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

    @ManyToMany
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToMany
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @Column(name = "quantity")
    private int quantity;
}
