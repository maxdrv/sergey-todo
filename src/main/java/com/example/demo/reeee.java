package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class reeee{
        public static void main(String[] args) throws IOException {

        List<TodoList> todoLists = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try (BufferedReader reader = new BufferedReader(new FileReader("задачи.txt"))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                TodoList todoList = new TodoList(count++, line);
                todoLists.add(todoList);


            }
            int lastIndex = count;
            FileWriter writer = new FileWriter("index.txt");
            writer.write(String.valueOf(lastIndex));
            writer.close();
            System.out.println("Файл с индексом создан.");

        }

        FileWriter writer = new FileWriter("test.json");
        objectMapper.writeValue(writer, todoLists);
        writer.close();
    }
}