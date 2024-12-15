public class Node<T> {
    T element;
    Node<T> next;
    Node<T> prev;

    public Node(T element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
