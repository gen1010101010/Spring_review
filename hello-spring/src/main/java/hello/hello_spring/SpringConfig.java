package hello.hello_spring;


import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 정형화되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록함.
// 일반적으론 컴포넌트 스캔 사용(어노테이션 사용하는 것)
@Configuration //Service 같은 어노테이션을 쓰지 않고 할 수 있게 하는 법. Controller는 어쩔 수 없다.
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
