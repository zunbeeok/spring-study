package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepository
  extends JpaRepository<Member, Long>, MemberRepository {
  //이렇게 특유 속성이 있는 경우는 공통으로 인터페이스를 짜기 어렵다. 하지만 스프링 데이터jpa에서는 최대한 생략하기 위해 규칙을 만들었다.
  //select m from Member m where m.name = ?
  //인터페이스 이름만으로 최대한 쉽게 만들 수 있다.
  @Override
  Optional<Member> findByName(String name);
}
