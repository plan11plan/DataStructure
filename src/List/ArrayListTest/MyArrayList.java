package List.ArrayListTest;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList {
    public static void main(String[] args) {
        //생성
        ArrayList<Integer> numbers = new ArrayList<>();
        //넣기
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1,10);
        System.out.println(numbers);
        //삭제하기
        numbers.remove(0);
        System.out.println(numbers);
        numbers.remove(0);
        System.out.println(numbers);
        //꺼내기
        System.out.println(numbers.get(0));
        System.out.println(numbers.get(1));
        //사이즈
        System.out.println(numbers.size());
        //반복1
        Iterator it =numbers.iterator();
        while(it.hasNext()){
            int value= (int)it.next();
            System.out.println("값 출력");
            System.out.println(value);
        }
        //반복2
        for(int value:numbers){
            System.out.println("값 출력");
            System.out.println(value);
        }
    }
}
