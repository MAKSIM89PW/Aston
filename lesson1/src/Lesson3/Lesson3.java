package Lesson3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class Lesson3 {
    public static void main(String[] args) {
        // Пример с ArrayList
        System.out.println("ArrayList Example:");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Element 1"); // Добавление в конец
        arrayList.add(0, "Element 0"); // Добавление в начало
        arrayList.add(2, "Element 2"); // Добавление в середину
        System.out.println("ArrayList: " + arrayList);

        arrayList.remove("Element 1"); // Удаление элемента
        System.out.println("ArrayList after removal: " + arrayList);

        // Пример с LinkedList
        System.out.println("\nLinkedList Example:");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Element A"); // Добавление в конец
        linkedList.addFirst("Element B"); // Добавление в начало
        linkedList.add(1, "Element C"); // Добавление в середину
        System.out.println("LinkedList: " + linkedList);

        linkedList.remove("Element A"); // Удаление элемента
        System.out.println("LinkedList after removal: " + linkedList);

        // Пример с HashMap
        System.out.println("\nHashMap Example:");
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Value 1"); // Добавление элемента
        hashMap.put(2, "Value 2");
        hashMap.put(3, "Value 3");
        System.out.println("HashMap: " + hashMap);

        hashMap.remove(2); // Удаление элемента
        System.out.println("HashMap after removal: " + hashMap);

        // Вывод всех элементов HashMap
        System.out.println("Entries in HashMap:");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}