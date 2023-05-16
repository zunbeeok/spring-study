package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(
        basePackages = "hello.core.member", // 이렇게 하면 언급된 패키지 까지만 조회한다.
        basePackageClasses =  AutoAppConfig.class, //업금된 클래 스의 패키지 1번째 줄 의 패키지
        // 위에 다 지정안하면 default로 가진다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //자동으로 하는걸 방지
)
public class AutoAppConfig {
    //ComponentScan은 @Configuration, @Component 클래스를 전부 끌여 올린다.
}
