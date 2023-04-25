package hello.hellospring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest //Spring 풀테스트 기준.
@Transactional //기존 테스트에서 BeforEach를 썼던 이유는 메모리를 초기화 해주기 위함.
// transactional 개념이 보통 db에는 있어서 transactional을 적용시 commit을 하기전까지는 db에 적용이 되지 않는다.
// 보통 테스트 진행시에는 local DB로 연결한다.(환경변수 같은걸 사용하나?)
//transactional은 테스트 케이스에 붙을때만 롤백을 한다.
// 단위 테스트는 가볍고 기능만 테스트 하기 좋다.
// 풀테스트만 한다고 꼭 좋다는 테스트는 아니다. 하지만 필요한 상황에 맞춰서 테스트를 해야한다.
public class MemberServiceIntegrationTest {

  // MemberService memberService = new MemberService();
  // MemoryMemberRepository memberRepository = new MemoryMemberRepository();
  // 위에 MemoryMemberRepository와 MemberService의 레퍼지토리가 다른 레퍼지토리다.
  //두개의 클래스를 두개 다 부르는게 좋지 않다.

  @Autowired
  MemberService memberService;

  @Autowired
  MemberRepository memberRepository;

  //테스트 코드는 항상 given > when > then 기준으로 테스트한다.
  //given : 테스트 대상
  //when  : 테스트 할 내용
  //then  : 결과

  //해당 테스트는 반쪽자리 테스트.
  //회원가입의 경우 가입이 되거나 안되거나 둘중하나다. 이 소스는 되는 경우만 계산
  @Test
  void 회원가입() {
    //given
    Member member = new Member();
    member.setName("test");

    //when
    Long saveId = memberService.join(member);

    //then
    Member findMember = memberService.findOne(saveId).get();
    assertThat(member.getName()).isEqualTo(findMember.getName());
  }

  @Test
  void 중복회원가입() {
    //given
    Member member1 = new Member();
    member1.setName("test");

    Member member2 = new Member();
    member2.setName("test");

    //when
    memberService.join(member1);

    // 람다식 로직이 실행됬을시 해당 클래스가 나와야한다.
    // assertThrows(IllegalStateException.class, () -> memberService.join(member2));

    IllegalStateException e = assertThrows(
      IllegalStateException.class,
      () -> memberService.join(member2)
    );

    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    // 좋지 못한 방법
    // try{
    //     memberService.join(member2);
    //     fail();
    // }catch(IllegalStateException e){
    //     //then
    //     assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    // }

  }
}
