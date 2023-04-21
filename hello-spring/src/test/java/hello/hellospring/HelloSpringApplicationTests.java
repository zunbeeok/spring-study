package hello.hellospring;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class HelloSpringApplicationTests {

	//임시용 회원 DB초기화;
	MemoryMemberRepository repository =  new MemoryMemberRepository();

	//callback 메소드 같은거
	// 테스트 케이스가 끝날때 마다 초기화가 된다.
	// @AfterEach
	// public void afterEach(){
	// 	repository.clearStore();
	// }

	@Test
	public void save(){
		//given
		Member member = new Member();
		member.setName("spring");

		//when
		repository.save(member);

		//then
		Member result = repository.findById(member.getId()).get();
		assertThat(result).isEqualTo(member);
	}


	@Test
	public void findByName(){
		//given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		//when
		Member result = repository.findByName("spring1").get();

		//then
		assertThat(result).isEqualTo(member1);
	}

	@Test
	public void findAll(){
		//given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		//when
		List<Member> result = repository.findAll();

		//then
		assertThat(result.size()).isEqualTo(2);
	}


	@Test
	void contextLoads() {
	}

}
