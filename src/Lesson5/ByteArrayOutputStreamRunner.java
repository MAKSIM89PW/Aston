package ru.aston.java.base.lesson6.io.iostream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamRunner {

    public static void main(String[] args) {

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            String text = "Hello Wolrd!";
            byte[] buffer = text.getBytes();
            baos.write(buffer);
            // превращаем массив байтов в строку
            System.out.println(baos.toString());

            // получаем массив байтов и выводим по символьно
            byte[] array = baos.toByteArray();
            for (byte b : array) {
                System.out.print((char) b);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

package ru.aston.java.base.lesson6.nio;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class NIOByteArrayOutputStreamRunner {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        String text = "Hello Wolrd!";
        byte[] buffer = text.getBytes();

        byteBuffer.put(buffer);
        byteBuffer.flip();

        System.out.println(StandardCharsets.UTF_8.decode(byteBuffer));

        byteBuffer.rewind();
        while (byteBuffer.hasRemaining()) {
            System.out.print((char) byteBuffer.get());
        }
    }
}
