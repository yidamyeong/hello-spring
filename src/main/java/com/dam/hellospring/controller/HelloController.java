package com.dam.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hallo");
        return "hello";
    }

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("id", "jess");
        model.addAttribute("nickname", "dam0");
        return "login";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        // required 디폴트가 트루임. 그럼 파라미터 안 넘어오면 에러난다.
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody  // HTTP Body 부에 리턴되는 데이터를 직접 넣어주겠다는 의미
    public String helloString(@RequestParam(value = "name", required = false) String name) {
        return "hello " + name;  // hello spring, hello kim, etc..
    }

    @GetMapping("hello-api")
    @ResponseBody  // 객체일 때 JSON 데이터 방식으로 응답 (디폴트값)
    public Hello helloApi(@RequestParam(value = "name", required = false) String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
