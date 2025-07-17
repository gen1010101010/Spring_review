package hello.hello_spring.domain;

//여기서 Member 객체는 하나의 id, name을 갖는 묶음이다.
public class Member {
    private long id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
