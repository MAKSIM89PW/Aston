package Home1706;

/**
 * Простой LinkedList без использования стандартных методов Collection.
 */
public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;

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
        if (index == 0) {
            T removedElement = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return removedElement;
        } else {
            Node<T> previous = getNode(index - 1);
            Node<T> current = previous.next;
            previous.next = current.next;
            if (current.next == null) {
                tail = previous;
            }
            size--;
            return current.data;
        }
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
    public MyLinkedList<T> subList(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkIndex(toIndex - 1);
        MyLinkedList<T> subList = new MyLinkedList<>();
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
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
