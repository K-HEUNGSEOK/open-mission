package hello.itemservice.message;

import java.util.Locale;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

@SpringBootTest
public class MessageSourceTest {
    @Autowired
    MessageSource ms;

    @Test
    void helloMessage(){
        String result = ms.getMessage("hello", null, Locale.ENGLISH);
        Assertions.assertThat(result).isEqualTo("hello");
        System.out.println("하이");
        String message = ms.getMessage("rqr", null, null);
        Assertions.assertThat(message).isEqualTo("시발");
    }

    @Test
    void notFoundMeesageCode(){
        org.junit.jupiter.api.Assertions.assertThrows((NoSuchMessageException.class),
                () -> ms.getMessage("REqw",null,null));
    }

    @Test
    void defaultMeesageCode(){
        String result = ms.getMessage("no_code", null, "기본 메세지", null);
        Assertions.assertThat(result).isEqualTo("기본 메세지");
    }

    @Test
    void argumentMessage(){
        String message = ms.getMessage("hello.name", new Object[]{"spring"}, Locale.ENGLISH);
        Assertions.assertThat(message).isEqualTo("hello spring");
    }

}
