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
public class DeleteLine {
    @GetMapping("/delete")
    public String delete(@RequestParam(value = "name") int name) throws IOException {
        try {

            File file = new File("путь_к_файлу.txt");
            List<String> lines = new ArrayList<>();
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            lines.remove(name);
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (String line2 : lines) {
                bufferedWriter.write(line2);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Строка удалена";
    }
}
