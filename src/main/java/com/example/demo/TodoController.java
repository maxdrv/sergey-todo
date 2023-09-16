package com.example.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@Configuration
@Component
public class TodoController {    @GetMapping("/delete")
    public String delete(@RequestParam(value = "name") int name) throws IOException {
        try {
            File file = new File("задачи.txt");
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
    @GetMapping("/displLine")
    public String dispLine(@RequestParam(value = "line") int line) throws IOException {
        try {
            File file = new File("задачи.txt");
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
    @GetMapping("/add")
    public static String add(@RequestParam(value = "name1") String name1) throws IOException {
        List<TodoList> todoLists123 = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try (BufferedReader reader = new BufferedReader(new FileReader("задачи.txt"))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                TodoList todoList = new TodoList(count++, line);
                todoLists123.add(todoList);


            }
            int lastIndex = count;
            FileWriter writer = new FileWriter("index.txt");
            writer.write(String.valueOf(lastIndex));
            writer.close();
            System.out.println("Файл с индексом создан.");

        }

        FileWriter writer = new FileWriter("test.json");
        objectMapper.writeValue(writer, todoLists123);
        writer.close();


        try {
            FileWriter writer3 = new FileWriter("задачи.txt", true);
            writer3.write(name1 + "\n");
            ArrayList <TodoList> todoLists = new ArrayList<>();

            int count = 1;
            boolean resul = false;
            try (BufferedReader reader = new BufferedReader(new FileReader("задачи.txt"))) {
                TodoList todoList = new TodoList(0,name1);
                String line;

                while ((line = reader.readLine()) != null) {
                    TodoList todoList1 = new TodoList(count++,line);
                    todoLists.add(todoList1);
                }
            }
            int lastIndex = count;
            FileWriter writer2 = new FileWriter("index.txt");
            writer2.write(String.valueOf(lastIndex));
            writer2.close();
            System.out.println("Файл с индексом создан.");


            TodoList todoList3 = new TodoList(count,name1);
            todoLists.add(todoList3);
            writer.close();

            return "Данные успешно записаны в файл"+todoList3;
        } catch (IOException e) {
            return "Ошибка при записи в файл";
        }
    }

    @ResponseBody
    @GetMapping("/display")
    public String display() {
        try {
            FileReader reader = new FileReader("задачи.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("<br>");
            }

            reader.close();
            return "<html><body>" + stringBuilder.toString() + "</body></html>";
        } catch (IOException e) {
            return "Ошибка при чтении файла";
        }
    }
}
