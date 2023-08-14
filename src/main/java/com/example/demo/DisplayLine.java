package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@RestController
@Component
public class DisplayLine {
    @GetMapping("/displLine")
    public String dispLine(@RequestParam(value = "line") int line) throws IOException {
        try {

            File file = new File("путь_к_файлу.txt");
            File tempFile = new File("temp.txt");


            List<String> lines = new ArrayList<>();
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line1;
            while ((line1 = bufferedReader.readLine()) != null) {
                lines.add(line1);
            }

            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (String line2 : lines) {
                bufferedWriter.write(line2);
                bufferedWriter.newLine();
            }


            bufferedWriter.close();
            writer.close();
            return lines.get(line);
        } finally {

        }
    }
}
