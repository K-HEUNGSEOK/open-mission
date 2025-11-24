package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MappingController {

    @GetMapping("/hello-basic")
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }
    //url 자체에 값이 있을 때
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId){
        log.info("mapping path = {}", userId);
        return "ok";
    }

    @GetMapping("/mapping/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mapping path = {}, orderId = {}", userId, orderId);
        return "ok";
    }

    @PostMapping(value = "/mapping/consume", consumes = "application/json")
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }
    @PostMapping(value = "/mapping/produce", produces = "text/html")
    public String mappingProduce(){
        log.info("mappingProduce");
        return "ok";
    }
}
