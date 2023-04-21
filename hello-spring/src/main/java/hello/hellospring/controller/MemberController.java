package hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;

import java.util.List;

@Controller
public class MemberController {
 
    // memberController 기준에서는 클래스를 생성해서 다루는게 아니라 외부에서 집어 넣어주기 때문에 의존성을 주입한다.

    // private final MemberService memberService = new MemberService();
    private final MemberService memberService;

    //스프링 컨테이너에 등록하고 사용
    

    //Auotowired 어노테이션은 스프링이 서버 시작시 빈에 접속하여 연결해준다.

    //생성자 주입 방식
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    // 필드주입
    // @Autowired private MemberService memberService;


    // @GetMapping("members")
    // public List<Member> members(){
    //     return memberService.findMembers();
    // }

    //여기서 궁금한점 누가 저 Member 클래스를 생셩시켜주나?
    // @GetMapping("members/new")
    // public String membersNew(@RequestParam("name") String name,Member member){
    //     member.setName(name);
    //     memberService.join(member);
    //     return "membersNew";
    // }

    @GetMapping("/members")
    public String getAllMember(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/getMembers";
    }


    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(CreateForm form){
        // System.out.println(form);
        Member member =  new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

}

class CreateForm{
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}