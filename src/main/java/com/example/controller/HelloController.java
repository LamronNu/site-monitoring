package com.example.controller;

import com.example.service.HelloSpringService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@Getter
@Setter
@ManagedBean
//@Component
public class HelloController {

    @ManagedProperty("#{helloSpringService}")
//    @Autowired
    private HelloSpringService helloSpringService;

//    public void setHelloSpringService(HelloSpringService helloSpringService) {
//        this.helloSpringService = helloSpringService;
//    }

    public String sayHello() {
        return helloSpringService.sayHello();
    }
}
