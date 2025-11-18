package hello.itemservice.validation;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessageCodesResolverTest {
    MessageCodesResolver ms = new DefaultMessageCodesResolver();

    @Test
    void messagesCodesResolverObjects(){
        String[] messageCodes = ms.resolveMessageCodes("required", "item");
        System.out.println("messageCodes = " + Arrays.toString(messageCodes));
        Assertions.assertThat(messageCodes).containsExactly("required.item", "required");
        //messageCodes = [required.item, required]
    }
    @Test
    void messageCodesResolverField(){
        //1. 오류 코드 , 2. 객체이름, 3.필드 이름, 4. 필드 타입
        String[] messageCodes = ms.resolveMessageCodes("required", "item", "itemName", String.class);
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }
        Assertions.assertThat(messageCodes).containsExactly("required.item.itemName", "required.itemName","required.java.lang.String","required");
    }
}
