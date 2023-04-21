package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;;

@Controller
public class HelloController{

    //http 통신중 Get
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        //hello 템플릿에서 data 속성을 찾아서 value를 셋팅한다.

        return "hello";
        //return에 적힌 string은 resources/templates 폴더 하위에 html 확장자 파일명을 찾아간다.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    // 아래는 required 옵션을 줄 수 있다.
    // @GetMapping("hello-mvc")
    // public String helloMvc(@RequestParam(value="name", required = false) String name, Model model){
    //     model.addAttribute("name",name);
    //     return "hello-template";
    // }

    @GetMapping(value="hello-string")
    @ResponseBody
    public String getMethodName(@RequestParam("name") String name) {
        return "hello " +name;
        // HttpMessageConverter가 작동 => 일반 스트링이 return이기 때문에 StringConverter가 작동
    }
    
    @GetMapping(value="hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(value ="name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        // HttpMessageConverter가 작동 => 객체 이므로 JSON으로 변환 후 리턴;
    }
    

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name=name;
        }
    }
}