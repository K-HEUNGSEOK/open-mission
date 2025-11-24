package hello.core.sigleton;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class StatefulServiceTest {

  @Test
  void statefulServiceSingleTon(){
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    StatefulService statefulService1 = ac.getBean(StatefulService.class);
    StatefulService statefulService2 = ac.getBean(StatefulService.class);

    //A 사용자 1만원 주문
    statefulService1.order("userA", 10000);
    //B 사용자 2만원 주문
    statefulService1.order("userB", 20000);

    //A 사용자 주문금액 조회 -> 10000을 기대 했지만 20000원이 나옴
    int price = statefulService1.getPrice();

    assertThat(price).isEqualTo(20000);
  }

  @Configuration
  static class TestConfig{
    @Bean
    public StatefulService statefulService (){
      return new StatefulService();
    }
  }
}