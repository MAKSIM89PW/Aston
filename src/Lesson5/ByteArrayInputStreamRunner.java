package ru.aston.java.base.lesson6.io.iostream;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamRunner {

    public static void main(String[] args) {

        readAllBytes();

        readFiveChars();
    }

    private static void readAllBytes() {
        byte[] array1 = new byte[]{1, 3, 5, 7};
        ByteArrayInputStream byteStream1 = new ByteArrayInputStream(array1);
        int b;
        while ((b = byteStream1.read()) != -1) {
            System.out.println(b);
        }
    }

    private static void readFiveChars() {
        String text = "Hello world!";
        byte[] array2 = text.getBytes();
        // считываем 5 символов
        ByteArrayInputStream byteStream2 = new ByteArrayInputStream(array2, 0, 5);
        int c;
        while ((c = byteStream2.read()) != -1) {
            System.out.println((char) c);
        }
    }
}

package ru.aston.java.base.lesson6.nio;

import java.nio.ByteBuffer;

public class NIOByteArrayInputStreamRunner {

    public static void main(String[] args) {
        readAllBytes();
        readFiveChars();
    }

    private static void readAllBytes() {
        byte[] array1 = new byte[]{1, 3, 5, 7};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(array1);
        while (byteBuffer1.hasRemaining()) {
            System.out.println(byteBuffer1.get());
        }
    }

    private static void readFiveChars() {
        String text = "Hello world!";
        byte[] array2 = text.getBytes();
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(array2, 0, 5);
        while (byteBuffer2.hasRemaining()) {
            System.out.println((char) byteBuffer2.get());
        }
    }
}
