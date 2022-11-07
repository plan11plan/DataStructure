package List.ArrayListTest;

import List.ArrayListTest.ArrayList1;

public class Main {
    public static void main(String[] args) {
        ArrayList1 numbers = new ArrayList1();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addLast(40);
        System.out.println(numbers);
        //
        ArrayList1.ListIterator li=numbers.listIterator();

        System.out.println(li.next());
        System.out.println(li.next());

        //
        System.out.println("previous "+li.previous());
        System.out.println("previous "+li.previous());
        //
        System.out.println(numbers);
    }
}