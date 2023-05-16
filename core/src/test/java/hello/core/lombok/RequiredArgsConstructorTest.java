package hello.core.lombok;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class RequiredArgsConstructorTest {
    //궁금한게 두개 롬복 사용시 @RequiredArgsConstructor 사용시.
    // 1. 생성자가 여러개인 경우?
    // 2. 생성자가 여러개이고 Autowired를 따른곳에 저장한다면?
    // 3. Autowired시 class 생성시 값이 부족하다면?'

    @Test
    public void test(){
        new AnnotationConfigApplicationContext();
    }

//    @Component
//    static class CallClass{
////        private final TestBean testBean;
//        private TestBean testBean;
//
//    }

    @Component
    @RequiredArgsConstructor
    @Getter
    static class TestBean{
        private String args;



    }

    @Component
    @RequiredArgsConstructor
    @Getter
    static  class  TestBean2{
        private final String args;


    }


}
