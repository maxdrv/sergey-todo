package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.io.FileWriter;
import java.io.IOException;

@RestController
@Component
public class addController {
    @GetMapping("/add")
    public static String add(@RequestParam(value = "name1") String name1) {
        try {
            FileWriter writer = new FileWriter("путь_к_файлу.txt", true);
            writer.write(name1 + "\n");
            writer.close();
            return "Данные успешно записаны в файл";
        } catch (IOException e) {
            return "Ошибка при записи в файл";
        }
    }
}
