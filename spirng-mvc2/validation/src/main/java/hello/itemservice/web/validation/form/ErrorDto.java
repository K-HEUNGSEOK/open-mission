package hello.itemservice.web.validation.form;

import lombok.Data;

@Data
public class ErrorDto {
    private String filed;
    private String message;

    public ErrorDto(String filed, String message) {
        this.filed = filed;
        this.message = message;
    }
}
