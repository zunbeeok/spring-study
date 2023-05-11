package hello.core.member;

public class MemberServiceImpl implements MemberService {

  // private final MemberRepository memberRepository = new MemoryMemberRepository();
  private final MemberRepository memberRepository;

  /*
   * 기존에는 MemoryMemberRepository를 생성해서 사용했기 때문에 MemoryMemberRepository에 의존했지만
   * 현재는 생성자를 통해서  주입시켜준다. 주입은 AppConfig에서 한다.
   */
  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
