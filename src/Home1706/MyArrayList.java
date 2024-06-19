package Home1706;

import java.util.Arrays;

/**
 * Простой ArrayList без использования стандартных методов Collection.
 */
public class MyArrayList<T> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Конструктор по умолчанию. Создает список с начальной емкостью 10.
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент для добавления
     */
    public void add(T element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = element;
    }

    /**
     * Удаляет элемент по индексу.
     *
     * @param index индекс элемента для удаления
     * @return удаленный элемент
     */
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removedElement;
    }

    /**
     * Получает элемент по индексу.
     *
     * @param index индекс элемента для получения
     * @return элемент по указанному индексу
     */
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Заменяет элемент по индексу.
     *
     * @param index индекс элемента для замены
     * @param element элемент, который будет установлен
     * @return предыдущий элемент по указанному индексу
     */
    public T set(int index, T element) {
        checkIndex(index);
        T oldElement = (T) elements[index];
        elements[index] = element;
        return oldElement;
    }

    /**
     * Возвращает подсписок от fromIndex (включительно) до toIndex (исключительно).
     *
     * @param fromIndex начальный индекс (включительно)
     * @param toIndex конечный индекс (исключительно)
     * @return подсписок от fromIndex до toIndex
     */
    public MyArrayList<T> subList(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkIndex(toIndex - 1);
        MyArrayList<T> subList = new MyArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add((T) elements[i]);
        }
        return subList;
    }

    /**
     * Возвращает размер списка.
     *
     * @return количество элементов в списке
     */
    public int size() {
        return size;
    }

    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
    }
}
