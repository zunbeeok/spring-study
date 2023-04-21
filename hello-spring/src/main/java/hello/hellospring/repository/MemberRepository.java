package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

// @Repository
public interface MemberRepository {
    Member save(Member member);
    //Optional<T>  return Type : null || T;
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String Name);
    
    //보통 반복문을 사용하기 쉬운 List타입을 선호한다. 
    List<Member> findAll();
}
