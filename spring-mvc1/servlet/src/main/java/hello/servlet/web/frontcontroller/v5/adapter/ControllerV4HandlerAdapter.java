package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException, ServletException {
        ControllerV4 controller = (ControllerV4) handler;

        Map<String, String> paramMap = createParamMap(request);
        Map<String,Object> model = new HashMap<>();

        //논리 주소 반환 (이때 model에 값을 채워줌)
        String viewName = controller.process(paramMap, model);

        //어댑터 변환 (V4는 String 만 반환하기때문에 변환해줘야함)
        ModelView mv = new ModelView(viewName);
        mv.setModel(model);
        return mv;
    }

    private Map<String,String> createParamMap(HttpServletRequest request){
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames() //파라미터 다 가져옴
                .asIterator()
                .forEachRemaining(param -> paramMap.put(param,request.getParameter(param)));
        return paramMap;
    }
}
