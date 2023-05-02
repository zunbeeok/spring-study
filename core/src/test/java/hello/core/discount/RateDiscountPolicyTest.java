package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {

  //   private final MemberRepository memberRepository = new MemoryMemberRepository();
  private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

  @Test
  public void discount() {
    //given
    Member member = new Member(1L, "memberA", Grade.VIP);

    //when
    int discountPrice = discountPolicy.discount(member, 10000);

    //then
    Assertions.assertThat(discountPrice).isEqualTo(1000);
  }

  @Test
  public void noDiscount() {
    //given
    Member member = new Member(1L, "memberA", Grade.BASIC);

    //when
    int discountPrice = discountPolicy.discount(member, 100000);

    //then
    Assertions.assertThat(discountPrice).isEqualTo(0);
  }
}
