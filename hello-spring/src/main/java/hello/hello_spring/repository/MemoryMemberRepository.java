package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //ID값

    //하나의 데이터 묶음(id, name)인 Member를 리턴
    @Override
    public Member save(Member member) {
        member.setId(++sequence); //id 세팅
        store.put(member.getId(), member); //id(sequence)와 member를 Map(키, value)
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.of(store.get(id)); //Null로 반환될 가능성이 있으니 Optional로 감싸기
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(m -> m.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
