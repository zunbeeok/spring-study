package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

  private int discountPercent = 10;

  @Override
  public int discount(Member member, int price) {
    Grade grade = member.getGrade();
    if (grade == Grade.VIP) {
      return price * discountPercent / 100;
    } else {
      return 0;
    }
  }
}