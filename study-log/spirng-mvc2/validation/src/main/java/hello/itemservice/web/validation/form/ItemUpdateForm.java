package hello.itemservice.web.validation.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class ItemUpdateForm {
    @NotNull
    private Integer id;

    @NotBlank
    private String itemName;

    @NotNull
    @Range(min = 10000, max = 100000)
    private Integer price;
    //수정에서 수량은 자유롭게 변경할 수 있다.
    private Integer quantity;
}
