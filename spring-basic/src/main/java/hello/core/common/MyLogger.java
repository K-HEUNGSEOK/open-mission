package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.UUID;
import javax.naming.ldap.PagedResultsControl;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Setter
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) //가짜 클래스를 만듬
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void log(String message){
        System.out.printf("[%s] [%s] %s%n", uuid, requestURL, message);
    }
    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid +"] request scope bean create : " + this);
    }
    @PreDestroy
    public void close(){
        System.out.println("[" + uuid +"] request scope bean close : " + this);
    }
}
