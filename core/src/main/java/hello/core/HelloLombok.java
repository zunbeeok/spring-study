package hello.core;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor // 생성자 관련 지원
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void  main(String[] args){
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("test");


        Map<Integer,String> test = new HashMap<Integer, String>();
        test.put(1,"test1");
        test.put(2,"test2");
//        System.out.println("name = " + name);
        System.out.println(test);
        //{1=test1, 2=test2}
    }

}
