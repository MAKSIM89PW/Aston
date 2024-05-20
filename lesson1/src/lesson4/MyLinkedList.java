package lesson4;
import java.util.Collection;

public class MyLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public T remove(int index) {
        checkIndex(index);
        if (index == 0) {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }

        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }

    public void addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public int size() {
        return size;
    }

    public void bubbleSort() {
        if (size < 2) return;
        boolean swapped;
        do {
            swapped = false;
            Node<T> current = head;
            Node<T> prev = null;
            Node<T> next = head.next;

            while (next != null) {
                if (((Comparable<T>) current.data).compareTo(next.data) > 0) {
                    swapped = true;
                    if (prev == null) {
                        Node<T> temp = next.next;
                        next.next = current;
                        current.next = temp;
                        head = next;
                        prev = next;
                    } else {
                        Node<T> temp = next.next;
                        next.next = current;
                        current.next = temp;
                        prev.next = next;
                        prev = next;
                    }
                    next = current.next;
                } else {
                    prev = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (swapped);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(4);

        System.out.println("Before sorting: " + list);
        list.bubbleSort();
        System.out.println("After sorting: " + list);
    }
}