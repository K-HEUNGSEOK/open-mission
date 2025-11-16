package hello.mypractice.web.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {
    private final Map<Long,Item> store = new HashMap<>();
    private Long squence = 0L;

    public Item save(Item item){
        item.setItemId(++squence);
        store.put(item.getItemId(), item);
        return item;
    }

    public Item findById(Long itemId){
        return store.get(itemId);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clear(){
        store.clear();
    }

    public void updateItem(Long itemId, Item updateItem){
        Item findItem = store.get(itemId);
        findItem.setItemName(updateItem.getItemName());
        findItem.setPrice(updateItem.getPrice());
        findItem.setQuantity(updateItem.getQuantity());
    }
}
