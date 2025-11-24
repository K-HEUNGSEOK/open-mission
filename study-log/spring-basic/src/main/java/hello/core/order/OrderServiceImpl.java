package hello.core.order;

import hello.core.annotaion.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceImpl implements OrderService{
   private final MemberRepository memberRepository;
   private final DiscountPolicy discountPolicy;

  public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
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
