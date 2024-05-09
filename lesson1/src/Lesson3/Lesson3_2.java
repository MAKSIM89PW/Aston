package Lesson3;
import java.util.Arrays;

public class Lesson3_2<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public Lesson3_2() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public Lesson3_2(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.array = new Object[initialCapacity];
        this.size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedElement = (T) array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null; // Устанавливаем последний элемент в null для GC
        return removedElement;
    }

    public void addAll(Lesson3_2<T> other) {
        int newSize = size + other.size;
        if (newSize > array.length) {
            increaseCapacity(newSize);
        }
        System.arraycopy(other.array, 0, array, size, other.size);
        size = newSize;
    }

    private void increaseCapacity() {
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }

    private void increaseCapacity(int minCapacity) {
        int newCapacity = Math.max(array.length * 2, minCapacity);
        array = Arrays.copyOf(array, newCapacity);
    }

    public void bubbleSort() {
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) array[j]).compareTo((T) array[j + 1]) > 0) {
                    T temp = (T) array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // Если внутренний цикл не сделал ни одной замены, значит массив уже отсортирован
            if (!swapped) {
                break;
            }
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[size - 1]).append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Lesson3_2<Integer> list = new Lesson3_2<Integer>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);
        System.out.println("Original list: " + list);

        list.bubbleSort();
        System.out.println("Sorted list: " + list);
    }
}
