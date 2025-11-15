package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();
    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save() {
        Item item = new Item("test", 10000, 1);
        Item saveItem = itemRepository.save(item);
        Item findItem = itemRepository.findId(item.getId());
        Assertions.assertThat(findItem).isSameAs(saveItem);
    }

    @Test
    void findAll() {
        Item itemA = new Item("itemA", 10000, 1);
        Item itemB = new Item("itemB", 10000, 1);
        itemRepository.save(itemA);
        itemRepository.save(itemB);

        Assertions.assertThat(itemRepository.findAll().size()).isEqualTo(2);
        Assertions.assertThat(itemRepository.findAll()).containsExactly(itemA,itemB);
    }

    @Test
    void update() {
        Item item = new Item("itemA", 10000, 1);
        Item updateItem = new Item("itemB", 20000, 2);
        itemRepository.save(item);
        itemRepository.update(item.getId(), updateItem);

        Item findItem = itemRepository.findId(item.getId());
        Assertions.assertThat(findItem.getItemName()).isEqualTo(updateItem.getItemName());
        Assertions.assertThat(findItem.getPrice()).isEqualTo(updateItem.getPrice());
        Assertions.assertThat(findItem.getQuantity()).isEqualTo(updateItem.getQuantity());
    }
}