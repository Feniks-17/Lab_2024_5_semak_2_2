import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    //добавление элемента в конец списка
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    //добавление элемента по указанному индексу
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом нет в списке");
        }
        else if (index == size) {
            add(element);
        }
        else {
            Node<T> newNode = new Node<>(element);
            if (index == 0) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else {
                Node<T> current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
            }
            size++;
        }
    }

    //получение элемента по индексу
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом нет в списке");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    //удаление и возвращение элемента по индексу
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом нет в списке");
        }
        Node<T> current = head;
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            current = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return current.element;
    }

    //количество элементов в списке
    public int size() {
        return size;
    }

    //проверка на пустоту списка
    public boolean isEmpty() {
        return size == 0;
    }

    //создание экземпляра класса DoublyLinkedListIterator
    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator();
    }

    public class DoublyLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        //возвращает следующий элемент в списке
        @Override
        public T next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("В списке больше нет элементов");
            }
            T current_element = current.element;
            current = current.next;
            return current_element;
        }

        //проверка на наличие в списке следующего элемента
        @Override
        public boolean hasNext() {
            return current != null;
        }
    }
}