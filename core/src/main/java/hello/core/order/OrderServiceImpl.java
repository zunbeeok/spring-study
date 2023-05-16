package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceImpl implements OrderService {

  // private final MemberRepository memberRepository = new MemoryMemberRepository();

  /**
   * 역할과 구현을 분리.
   * 다형성도 활용하고, 인터페이스와 구현 객체를 분리
   * OCP,DIP 같은 객체지향 설계 원칙을 준수하지 못했다.
   *  => DIP 아래 보면 DiscountPolicy, FixDiscountPolicy, RateDiscountPolicy이 3개를 의존한다. 이중 두개는 구현체
   *  => OCP 지금 코드는 기능을 확장해서 변경하면 클라이언트 코드에 영향을 준다. 따라서 OCP 위반.
   */
  // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
  // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  @Autowired
  public OrderServiceImpl(
    MemberRepository memberRepository,
    DiscountPolicy discountPolicy
  ) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    //설계가 잘 된이유 orderService 입장에서는 discount의 정보를 몰라 member변수르르 그냥 던질뿐.
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
