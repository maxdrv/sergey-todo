package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class reeee{
        public static void main(String[] args) throws IOException {
        List<TodoList> todoLists = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try (BufferedReader reader = new BufferedReader(new FileReader("путь_к_файлу.txt"))) {
            String line;
            int count = 1;
            while ((line = reader.readLine()) != null) {
                TodoList todoList = new TodoList(count++, line, false);
                todoLists.add(todoList);
            }
        }

        FileWriter writer = new FileWriter("test.json");
        objectMapper.writeValue(writer, todoLists);
        writer.close();
    }
}