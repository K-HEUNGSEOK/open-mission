package hello.core.discount;

import static org.junit.jupiter.api.Assertions.*;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import java.sql.SQLOutput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {
  AppConfig appConfig = new AppConfig();
  DiscountPolicy discountPolicy = appConfig.discountPolicy();
  @Test
  @DisplayName("VIP 는 10프로 할인이 적용되어야 한다.")
  void vip_o(){
    //given
    Member member = new Member(1L, "memberVIP", Grade.VIP);
    int discount = discountPolicy.discount(member, 30000);
    Assertions.assertThat(discount).isEqualTo(3000);
  }
  @Test
  @DisplayName("VIP가 아니면 할인이 적용되선 안된다.")
  void vip_x(){
    //given
    Member member = new Member(1L, "memberVIP", Grade.BASIC);
    int discount = discountPolicy.discount(member, 20000);
    Assertions.assertThat(discount).isEqualTo(0);
  }
}