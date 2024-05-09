package ru.aston.java.base.lesson6.io.iostream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamRunner {
    public static void main(String[] args) {

        String text = "Hello Java world!"; // строка для записи
        try (FileOutputStream out = new FileOutputStream("resources/text3.txt");
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            // перевод строки в байты
            byte[] buffer = text.getBytes();
            bos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}

package ru.aston.java.base.lesson6.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOBufferedWriterRunner {
    public static void main(String[] args) {

        String text = "Hello Java world!";

        Path filePath = Paths.get("resources/text3.txt");

        try (FileChannel channel = FileChannel.open(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer byteBuffer = ByteBuffer.wrap(text.getBytes());
            channel.write(byteBuffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
