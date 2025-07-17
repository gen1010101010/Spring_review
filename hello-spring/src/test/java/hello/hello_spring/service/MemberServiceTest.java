package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberService();

    @AfterEach
    public void afterEach(){ //test 케이스로 파일 전체 실행했을 때 오류가 발생함. 그 오류를 해결해야 함. 테스트 케이스를 실행할 때마다 클리어
        memberRepository.clearStore();
    }



    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("Hello");
        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        Member member1 = new Member();
        member1.setName("홍홍");

        Member member2 = new Member();
        member2.setName("홍홍");

        memberService.join(member1);
        IllegalStateException e= assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try{
//            memberService.join(member2);
//            fail("예외가 발생");
//        }catch (IllegalStateException e){
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
    }

    @Test
    void 모든맴버찾기() {
    }

    @Test
    void 한명찾기() {
    }
}