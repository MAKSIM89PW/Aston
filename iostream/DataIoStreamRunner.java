package ru.aston.java.base.lesson6.io.iostream;

import java.io.*;

public class DataIoStreamRunner {
    public static void main(String[] args) {

        Person tom = new Person("Tom", 34, 1.68, false);
        // запись в файл
        writeDataToFile(tom);

        // обратное считывание из файла
        readDataFromFile();
    }

    private static void writeDataToFile(Person tom) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("resources/data.bin"))) {
            // записываем значения
            dos.writeUTF(tom.name);
            dos.writeInt(tom.age);
            dos.writeDouble(tom.height);
            dos.writeBoolean(tom.married);
            System.out.println("File has been written");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void readDataFromFile() {
        try (DataInputStream dos = new DataInputStream(new FileInputStream("data.bin"))) {
            // записываем значения
            String name = dos.readUTF();
            int age = dos.readInt();
            double height = dos.readDouble();
            boolean married = dos.readBoolean();
            System.out.printf("Name: %s  Age: %d  Height: %f  Married: %b",
                    name, age, height, married);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Person {
    public String name;
    public int age;
    public double height;
    public boolean married;

    public Person(String n, int a, double h, boolean m) {
        this.name = n;
        this.height = h;
        this.age = a;
        this.married = m;
    }
}

package ru.aston.java.base.lesson6.nio;

import java.io.*;
        import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIODataIoStreamRunner {
    public static void main(String[] args) {

        Person tom = new Person("Tom", 34, 1.68, false);
        // запись в файл
        writeDataToFile(tom);

        // обратное считывание из файла
        readDataFromFile();
    }

    private static void writeDataToFile(Person tom) {
        try (FileChannel channel = new FileOutputStream("resources/data.bin").getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.putUTF(tom.name);
            buffer.putInt(tom.age);
            buffer.putDouble(tom.height);
            buffer.put((byte) (tom.married ? 1 : 0));
            buffer.flip();
            channel.write(buffer);
            System.out.println("File has been written");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void readDataFromFile() {
        try (FileChannel channel = new FileInputStream("resources/data.bin").getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer);
            buffer.flip();
            String name = buffer.getUTF();
            int age = buffer.getInt();
            double height = buffer.getDouble();
            boolean married = buffer.get() == 1;
            System.out.printf("Name: %s  Age: %d  Height: %f  Married: %b",
                    name, age, height, married);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Person {
    public String name;
    public int age;
    public double height;
    public boolean married;

    public Person(String n, int a, double h, boolean m) {
        this.name = n;
        this.height = h;
        this.age = a;
        this.married = m;
    }
}

