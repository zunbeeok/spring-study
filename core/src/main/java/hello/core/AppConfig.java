package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
// import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//기존 : 현재 AppConfig를 보면 중복이 있고, 역할에 따른 구현이 잘 안보인다.

//리팩터링 후 : 중복을 제거하고, 역할에 따른 구현이 보이도록 리팩터링 하자.

//AppConfig 를 보면 역할과 구현 클래스가 한눈에 들어온다. 애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악할 수 있다.
// 팩터리 메서드 기반
@Configuration
public class AppConfig {

  //MemberServiceImpl이 생성자로 생성될때 MemoryMemberRepository를 생성시켜줌.
  @Bean
  public MemberService memberService() {
    System.out.println("call AppConfig.memberService");
    // return new MemberServiceImpl(new MemoryMemberRepository());
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    System.out.println("call AppConfig.memberRepository");
    return new MemoryMemberRepository();
  }

   @Bean
  public OrderService orderService() {
     System.out.println("call AppConfig.orderService");
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  @Bean
  public DiscountPolicy discountPolicy() {
    // return new FixDiscountPolicy();
    return new RateDiscountPolicy();
  }
}
/**
 * AppConfig 에서 할인 정책 역할을 담당하는 구현을 FixDiscountPolicy RateDiscountPolicy
객체로 변경했다.
이제 할인 정책을 변경해도, 애플리케이션의 구성 역할을 담당하는 AppConfig만 변경하면 된다.
클라이언트 코드인 OrderServiceImpl 를 포함해서 사용 영역의 어떤 코드도 변경할 필요가 없다.
구성 영역은 당연히 변경된다. 구성 역할을 담당하는 AppConfig를 애플리케이션이라는 공연의 기획자로
생각하자. 공연 기획자는 공연 참여자인 구현 객체들을 모두 알아야 한다.
 */
