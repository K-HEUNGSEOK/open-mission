package hello.mypractice.web.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private Long itemId;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public Item() {
    }
}
