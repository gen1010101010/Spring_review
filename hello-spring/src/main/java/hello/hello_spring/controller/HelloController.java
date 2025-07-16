package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; //resourcesD에 잇는 hello.html
    }

    @GetMapping("hello-mvc") //getmapping은 /hello-mvc라는 url요청이 들어왔을 떄 실행됨.
    public String helloMvc(@RequestParam("name") String name, Model model){ //@RequestParam("name") String name 이라는 것은 URL에서 name이라는 값을 파라미터로 추출. 즉 없으면 오류.
        model.addAttribute("name", name); // Model model은 뷰로 데이터를 넘겨주기 위한 객체이다. 즉 html에서 ${name}으로 값 사용 가능
        return "hello-template"; //resources/templates/hello-template.html을 찾아 실행
    }

    @GetMapping("hello-string")
    @ResponseBody //http에서 header와 body가 있는데 body에 값을 직접 넣겠다. 즉 ?name=youjin 이렇게 하면 html없이 값이 나온다.
    public String helloString(@RequestParam("name") String name){
        return "hello "+ name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체반환. 반환은 json으로 반환된다.

    }
    //1
    static class Hello{
        private String name;


        public String getName(){
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
