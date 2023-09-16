package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("путь_к_файлу.txt", true);
        String name1 = "Джигурда";
        writer.write(name1 + "\n");
        ArrayList<TodoList> todoLists = new ArrayList<>();

        int count = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader("путь_к_файлу.txt"))) {
            TodoList todoList = new TodoList(0, name1);
            String line;

            while ((line = reader.readLine()) != null) {
                TodoList todoList1 = new TodoList(count++, line);
                todoLists.add(todoList1);

            }
            int lastIndex = count;
            FileWriter writer2 = new FileWriter("index.txt");
            writer2.write(String.valueOf(lastIndex));
            writer2.close();
        }
        TodoList todoList3 = new TodoList(count, name1);
        todoLists.add(todoList3);
        writer.close();
        for (int i = 0; i < todoLists.size(); i++) {
            System.out.println(todoLists.get(i).getId()+" "+todoLists.get(i).getText());

        }

       // return "Данные успешно записаны в файл" + todoList3;
    }

}


