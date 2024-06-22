package Home1706;

/**
 * Простой двусвязный LinkedList
 */
public class MyDoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент для добавления
     */
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Удаляет элемент по индексу.
     *
     * @param index индекс элемента для удаления
     * @return удаленный элемент
     */
    public T remove(int index) {
        checkIndex(index);
        Node<T> current = getNode(index);
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        size--;
        return current.data;
    }

    /**
     * Получает элемент по индексу.
     *
     * @param index индекс элемента для получения
     * @return элемент по указанному индексу
     */
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
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
        Node<T> node = getNode(index);
        T oldElement = node.data;
        node.data = element;
        return oldElement;
    }

    /**
     * Возвращает подсписок от fromIndex (включительно) до toIndex (исключительно).
     *
     * @param fromIndex начальный индекс (включительно)
     * @param toIndex конечный индекс (исключительно)
     * @return подсписок от fromIndex до toIndex
     */
    public MyDoublyLinkedList<T> subList(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkIndex(toIndex - 1);
        MyDoublyLinkedList<T> subList = new MyDoublyLinkedList<>();
        Node<T> current = getNode(fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(current.data);
            current = current.next;
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

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
    }

    private Node<T> getNode(int index) {
        Node<T> current;
        if (index < (size >> 1)) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}
