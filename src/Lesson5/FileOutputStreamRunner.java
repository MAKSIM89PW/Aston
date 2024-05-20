package ru.aston.java.base.lesson6.io.iostream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamRunner {
    public static void main(String[] args) throws IOException {
        System.out.println();
        try (FileOutputStream outputStream = new FileOutputStream("resources/text2.txt", true)) {
            String value = "Hello World2!";
            outputStream.write(value.getBytes());
//            outputStream.write(System.lineSeparator().getBytes());
        }
    }
}


package ru.aston.java.base.lesson6.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NIOFileOutputStreamRunner {
    public static void main(String[] args) throws IOException {
        try {
            String value = "Hello World2!" + System.lineSeparator();
            Files.write(Paths.get("resources/text2.txt"), value.getBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
