package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

import org.springframework.stereotype.Repository;



//임시로 구현부.
//메모리에 저장하기 위한 임시 클래스
//해당 클래스는 스프링에 대한 간단한 실습으로 동시성 문제가 고려되지 않음.
// 실무에서는 HashMap => ConcurrentHashMap , long => AtomicLong을 사용 함.
// @Repositorys
public class MemoryMemberRepository  implements MemberRepository{
    
    //메모리에 저장하기 때문에 회원의 정보가 저장될 hashMap구현
    private static Map<Long, Member> store = new HashMap<>();
    
    //아이디 생성시 회원의 고유 번호가 생성되기 위함.
    private static long sequence = 0L;

    @Override
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        // System.out.printf("신규 회원이 생성 되었습니다.\n 회원 정보 : %d \n 회원 이름 : %s \n 회원 객체의 주소 : %s\n",sequence, member.getName(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id){
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Member> findByName(String name){
        System.out.println(store.values().stream());
        return store.values().stream()
            .filter(member -> member.getName().equals(name))
            .findAny();
    }

    public void clearStore(){
        store.clear();
    }

}
