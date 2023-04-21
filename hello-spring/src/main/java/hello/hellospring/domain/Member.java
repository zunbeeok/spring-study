package hello.hellospring.domain;

//도메인
//해당 프로젝트에 목표는 회원관리이다.
//회원 관리에 필요한 회원 객체를 정의하고 생성하는 곳.
//회원가입, 조회 두개의 기능을 위해서는 회원만 있으면되니 Member객체만 생성

public class Member {
    //회원의 고유 ID (pk)
    private Long id;
    
    //회원등록시 등록한 이름.
    private String name;

    //기본 get set 메소드.
    //자바에서는 캡슐화(클래스 내부의 속성을 보호하기 위해)를 위해 속성은 private , 메소드듣 public으로 한다.
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
