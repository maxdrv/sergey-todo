package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import java.io.*;//

@SpringBootApplication
@RestController
@ComponentScan
public class DemoApplication {
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        TodoController controller = ctx.getBean(TodoController.class);
        controller.display();
    }
}











