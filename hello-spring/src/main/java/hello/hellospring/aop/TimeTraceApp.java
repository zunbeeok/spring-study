package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component // Component를 써도되고 AOP 같은 경우는 SpringConfig에 bean에 직접 등록해주는게 좋다.
public class TimeTraceApp {

  @Around("execution(* hello.hellospring.service..*(..))") //execute를 사용하여 원하는 범위만 적용 가능.
  public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    System.out.println("START: " + joinPoint.toString());
    try {
      Object result = joinPoint.proceed();
      return joinPoint.proceed();
    } finally {
      long finish = System.currentTimeMillis();
      long timeMs = finish - start;
      System.out.println("END: " + joinPoint.toString() + " " + timeMs + " ms");
    }
  }
}
