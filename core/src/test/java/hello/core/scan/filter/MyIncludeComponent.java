package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // 타입이면 클래스 레벨에 붙는거
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
