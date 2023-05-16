package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    @SpringBootTest
    static class TestBean{
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
            // required = false로 인해 자동 주입할 대상이 없을시 메소드를 실행하지 않음.
        }

        @Autowired
        public void  setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = "+noBean2);
            //null로 찍힌다.
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
            //Optional.empty 로 찍힘.
        }

        // 결과
        // noBean2 = null
        // noBean3 = Optional.empty
    }
}
