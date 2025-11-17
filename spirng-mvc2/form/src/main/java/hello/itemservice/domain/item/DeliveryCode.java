package hello.itemservice.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryCode {
    private String code; //FAST SLOW 이런거
    private String displayName; //빠른 배송 느린배송
}
