package hello.springmvc.basic.response;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ResponseBodyController {
    @RequestMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response ) throws IOException{
        response.getWriter().write("ok");
    }
    @RequestMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2(){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
    @RequestMapping("/response-body-string-v3")
    @ResponseBody
    public String responseBodyV3() throws IOException{
        return "ok";
    }
}
