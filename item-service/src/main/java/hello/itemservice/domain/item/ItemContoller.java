package hello.itemservice.domain.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemContoller {

    @RequestMapping("test-items")
    public String items(){
        return "items.html";
    }
}
