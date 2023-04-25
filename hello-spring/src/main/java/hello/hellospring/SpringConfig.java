package hello.hellospring;

import hello.hellospring.aop.TimeTraceApp;
import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTempleteMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.repository.SpringDataJpaMemberRepository;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링에서 제공하는 configuration만 조정해서 memory => jdbc로 변경했다.
@Configuration
public class SpringConfig {

  private final MemberRepository memberRepository;

  @Autowired
  DataSource dataSource;

  // @Autowired
  EntityManager entityManager;

  @Autowired
  public SpringConfig(
    DataSource dataSource,
    MemberRepository memberRepository
  ) {
    this.dataSource = dataSource;
    this.memberRepository = memberRepository;
  }

  @Bean
  public MemberService memberService() {
    // return new MemberService(memberRepository());
    return new MemberService(memberRepository);
  }
  // @Bean
  // public MemberRepository memberRepository() {
  //   // return new MemoryMemberRepository();
  //   // return new JdbcMemberRepository(dataSource);
  //   // return new JdbcTempleteMemberRepository(dataSource);
  //   // return new JpaMemberRepository(entityManager);
  // }

  // @Bean
  // public TimeTraceApp timeTraceApp(){

  // }
}
