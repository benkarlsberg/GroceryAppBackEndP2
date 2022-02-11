package com.revature.models;
/*
item_id(serial)(pk)
item_name(varchar)
price(decimal)
item_description(varchar)
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //Marks this Class as having representation in the Database (Has a Table)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", updatable = false)
    private int id;
    @Column(name = "item_name")
    private String item_name;
    @Column(name = "price")
    private double price;
    @Column(name = "item_description")
    private String item_description;

    @ManyToOne //Many items in one Cart Item
    @JoinColumn(name = "cart_item_id")
    private CartItem cartItem;

}
