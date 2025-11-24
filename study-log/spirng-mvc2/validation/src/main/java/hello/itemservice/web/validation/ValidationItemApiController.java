package hello.itemservice.web.validation;

import hello.itemservice.web.validation.form.ErrorDto;
import hello.itemservice.web.validation.form.ItemSaveForm;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {
    @PostMapping("/add")
    public Object addItem(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult){
        log.info("API 컨트롤러 호출");

        if (bindingResult.hasErrors()){
            log.info("검증 오류 발생 = {}", bindingResult);
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            List<ErrorDto> collect = fieldErrors.stream()
                    .map(e -> new ErrorDto(e.getField(), e.getDefaultMessage()))
                    .collect(Collectors.toList());

            return collect;
        }

        log.info("성공 로직 실행");
        return form;
    }
}
