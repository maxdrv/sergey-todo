package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@RestController
public class DemoApplication {
    public static void main(String[] args) throws IOException {

        SpringApplication.run(DemoApplication.class, args);
        File file = new File("storage.txt");


    }

    @GetMapping("/add")
    public String add(@RequestParam(value = "name1") String name1) {
        try {
            FileWriter writer = new FileWriter("путь_к_файлу.txt", true);
            writer.write(name1 + "\n");
            writer.close();
            return "Данные успешно записаны в файл";
        } catch (IOException e) {
            return "Ошибка при записи в файл";
        }
    }

    @GetMapping("/displ_all")
    public String getText() {
        try {
            FileReader reader = new FileReader("путь_к_файлу.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("<br>");

            }

            reader.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            return "Ошибка при чтении файла";
        }
    } @GetMapping("/delete")
    public String delete(@RequestParam(value = "name") int name) throws IOException {
        try {

            File file = new File("путь_к_файлу.txt");
            File tempFile = new File("temp.txt");


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
            return "Строка успешно удалена из файла";

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/displ")
    public String disp(@RequestParam(value = "line") int line) throws IOException {
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


    //@GetMapping("/delete")
    //public String delete(@RequestParam(value = "name") int name) throws IOException {
        //    try {
            //        File file = new File("путь_к_файлу.txt");
            //        File tempFile = new File("temp.txt");
            //
            //
            //        List<String> lines = new ArrayList<>();
            //        FileReader reader = new FileReader(file);
            //        BufferedReader bufferedReader = new BufferedReader(reader);
            //
            //        String line;
            //        while ((line = bufferedReader.readLine()) != null) {
                //            lines.add(line);
                //        }
            //
            //        FileWriter writer = new FileWriter(file);
            //        BufferedWriter bufferedWriter = new BufferedWriter(writer);
            //
            //        for (String line2 : lines) {
                //            bufferedWriter.write(line2);
                //            bufferedWriter.newLine();
                //        }
            //
            //        bufferedWriter.close();
            //        writer.close();
            //        return lines.remove(name);
            //    } finally {
            //
            //    }
        //}

        @GetMapping("/display")
        public String display () {
            try {
                FileReader reader = new FileReader("путь_к_файлу.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);
                StringBuilder stringBuilder = new StringBuilder();

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("<br>");
                }

                reader.close();
                return stringBuilder.toString();
            } catch (IOException e) {
                return "Ошибка при чтении файла";
            }
        }
    }








