package hello.core.member;


import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {
  AppConfig appConfig = new AppConfig();
  MemberService memberService = appConfig.memberService();
  @Test
  void join(){
    Member member = new Member(1L, "memberA", Grade.VIP);

    memberService.join(member);

    Assertions.assertThat(member).isEqualTo(memberService.findMember(1L));
  }
}