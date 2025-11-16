package hello.mypractice.web;

import hello.mypractice.web.domain.Item;
import hello.mypractice.web.domain.ItemRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basic/items")
public class ItemController {
    private final ItemRepository itemRepository;
    @PostConstruct
    public void init(){
        Item itemA = new Item("itemA", 10000, 10);
        Item itemB = new Item("itemB", 20000, 20);
        itemRepository.save(itemA);
        itemRepository.save(itemB);
    }
    @GetMapping
    public String items(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }
    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId ,Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute Item item, RedirectAttributes redirectAttributes){
        itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", item.getItemId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/items/{itemId}";
    }
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/editForm";
    }
    @PostMapping("/{itemId}/edit")
    public String edit(@ModelAttribute Item item, @PathVariable Long itemId) {
        itemRepository.updateItem(itemId,item);
        return "redirect:/basic/items/{itemId}";
    }

}
