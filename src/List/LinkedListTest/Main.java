package List.LinkedListTest;

public class Main {
    public static void main(String[] args) {
        LinkedList1 numbers = new LinkedList1();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addLast(40);
        System.out.println(numbers);

        LinkedList1.ListIterator i =numbers.listIterator();
        i.remove();

    }
}