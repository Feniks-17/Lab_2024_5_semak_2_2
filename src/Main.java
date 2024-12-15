public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("Апельсин");
        list.add("Банан");
        list.add("Виноград");
        list.add("Гранат");

        list.add(3, "Вишня");

        System.out.println(list.get(1));

        System.out.println(list.remove(2));

        System.out.println(list.size());

        System.out.println(list.isEmpty());

        System.out.println("Элементы в списке: ");
        for (String element : list) {
            System.out.println(element);
        }

    }
}