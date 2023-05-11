package hello.core.singleton;

public class SingletonService {
    // static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    //2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static  SingletonService getInstance(){
        return instance;
    }

    //3. 생성자를 private으로 선언해서 외부에서 NEW 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService(){
    }

    public  void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

    /*
     * 싱글톤 패턴의 문제
     * 기본적으로 들어가는 코트가 많다.
     * 의존관계쌍 클라이언트가 구체 클레스에 의존한다. (OCP, DI 위반)
     * 내부 속성을 변경하거나 초기화 하기 어렵다.
     * private 생성자로 자식 클래스를만들기 어렵다.
     * 결론적으로 유연성이 떨어진다.
     * 안티패턴으로 불리기도 한다.
     */


}
