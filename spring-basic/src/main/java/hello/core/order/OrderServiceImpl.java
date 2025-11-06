package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
   private final MemberRepository memberRepository;
   private final DiscountPolicy discountPolicy;
  //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //추상에도 의존하고 구체에도 의존함 DIP 위반
 // private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 그리고 코드를 바꿔야함 OCP 위반


  @Autowired
  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order crateOrder(Long memberId, String itemName, int itemPrice) {
    Member findMember = memberRepository.findById(memberId);
    //어차피 policy 에서 검증을함
    int discount = discountPolicy.discount(findMember, itemPrice);

    return new Order(memberId, itemName, itemPrice, discount);
  }

  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
