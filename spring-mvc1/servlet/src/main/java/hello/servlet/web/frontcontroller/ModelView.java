package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelView {
    private Map<String,Object> model = new HashMap<>();
    private String viewName;

    public ModelView(String viewName) {
        this.viewName = viewName;
    }
}
