package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //회원가입
    public Long join(Member member) {
        // 같은 이름이름이 있는 중복회원은 안된다.
        memberRepository.findById(member.getId())
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        
        memberRepository.save(member);
        return member.getId();
    }
    
    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    //회원 1명 조회
    public Optional<Member> findOne(long memberId) {
        return memberRepository.findById(memberId);

    }
}
