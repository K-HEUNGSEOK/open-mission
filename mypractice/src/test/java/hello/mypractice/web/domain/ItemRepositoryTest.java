package hello.mypractice.web.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();
    @AfterEach
    void init(){
        itemRepository.clear();
    }
    @Test
    void save() {
        Item item = new Item("itemA", 1000, 1);
        Item saveItem = itemRepository.save(item);
        Item findItem = itemRepository.findById(item.getItemId());
        Assertions.assertThat(saveItem).isEqualTo(findItem);
    }


    @Test
    void findAll() {
        Item itemA = new Item("itemA", 1000, 1);
        Item itemB = new Item("itemB", 1000, 1);
        itemRepository.save(itemA);
        itemRepository.save(itemB);
        List<Item> items = itemRepository.findAll();
        Assertions.assertThat(items).contains(itemA,itemB);
    }

    @Test
    void updateItem(){
        Item update = new Item("test", 20000, 20);
        Item item = new Item("itemA", 10000, 10);
        itemRepository.save(item);
        itemRepository.updateItem(item.getItemId(), update);
        Assertions.assertThat(item.getItemName()).isEqualTo(update.getItemName());
        Assertions.assertThat(item.getPrice()).isEqualTo(update.getPrice());
        Assertions.assertThat(item.getQuantity()).isEqualTo(update.getQuantity());

    }
}