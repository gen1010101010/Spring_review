package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){ //test 케이스로 파일 전체 실행했을 때 오류가 발생함. 그 오류를 해결해야 함. 테스트 케이스를 실행할 때마다 클리어
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("홍길동");
        repository.save(member);

        Member result=repository.findById(member.getId()).get();
        //System.out.println("result = "+(result==member));
        //Assertions.assertEquals(member, result);
        Assertions.assertThat(member).isEqualTo(result);

    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("홍길동동");
        repository.save(member1);


        Member member2 = new Member();
        member2.setName("홍길동홍");
        repository.save(member2);

        Member result=repository.findByName("홍길동동").get();

        Assertions.assertThat(result).isEqualTo(member1);


    }
    public void findAll(){
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setName("홍길동1");
        member2.setName("홍길동2");
        repository.save(member1);
        repository.save(member2);
        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2); //정수는 일치하는 것의 갯수
        
    }

}
