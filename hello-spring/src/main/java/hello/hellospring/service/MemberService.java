package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Service
public class MemberService {

  // 기존코드 => 클래스 안에서 직접생성
  // private final MemberRepository memberRepository =  new MemoryMemberRepository();

  // DI개념
  // 클래스가 생성될 때 memberRepository를 넘겨준다.
  // service 입장에서 보면 repository를 생성하지않고 외부에서 주입해주기 때문에 의존성을 주입한다. 의존성 주입.
  private final MemberRepository memberRepository;

  @Autowired
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  /**
   * 회원가입
   */
  public Long join(Member member) {
    validateDuplicateMember(member);
    memberRepository.save(member);
    return member.getId();
  }

  /**
   *
   * @param member
   *
   * 회원의 이름이 중복체크
   */
  public void validateDuplicateMember(Member member) {
    //findByName메소드가 return 타입이 Optional이기 떄문에 .ifPresent가 작동가능
    //ifPresent는 null이 아닐시 작동
    memberRepository
      .findByName(member.getName())
      .ifPresent(m -> {
        throw new IllegalStateException("이미 존재하는 회원입니다.");
      });
  }

  /**
   * 전체 회원 조히
   */
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
