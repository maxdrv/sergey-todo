package com.example.demo;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@org.springframework.stereotype.Controller
@Configuration
@Component
public class Controller {
    @ResponseBody
    @GetMapping("/display")
    public String display() {
        try {
            FileReader reader = new FileReader("путь_к_файлу.txt");
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

    //  @GetMapping("/display")
    //  public String display() {
        //      try {
            //          FileReader reader = new FileReader("путь_к_файлу.txt");
            //          BufferedReader bufferedReader = new BufferedReader(reader);
            //          StringBuilder stringBuilder = new StringBuilder();

            //          String line;
            //          while ((line = bufferedReader.readLine()) != null) {
                //              stringBuilder.append(line).append("<br>");

                //          }

            //          reader.close();
            //          return stringBuilder.toString();
            //      } catch (IOException e) {
            //          return "Ошибка при чтении файла";
            //      }
        //  }
    //
//    public ArrayList<String> display() {
//        ArrayList<String> strings = new ArrayList<>();
//        Scanner scanner = new Scanner("путь_к_файлу.txt");
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            strings.add(line);
//            //str = scanner.nextLine();
//            //System.out.println(scanner.nextLine());
//        }
//        scanner.close();
//        for (int i = 0; i < strings.size(); i++) {
//            System.out.println(strings.get(i));
//
//        }
//        return stringBuilder.toString();
//    }
//
//}
//        try {
//            FileReader reader = new FileReader("путь_к_файлу.txt");
//            BufferedReader bufferedReader = new BufferedReader(reader);
//            StringBuilder stringBuilder = new StringBuilder();
//
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line).append("<br>");
//            }
//            reader.close();
//            return stringBuilder.toString();
//        } catch (IOException e) {
//            return "Ошибка при чтении файла";
//        }
//
//    }
//}