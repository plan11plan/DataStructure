package Stack;

import java.util.Scanner;

//int형 고정 길이 스택
public class Stack1 {
    private int ptr; //스택 포인터
    private int Size; //스택 용량
    private int[] stack; //스택용 배열

    // 실행 시 예외:스택이 비어있음
    public class EmptyIntStackException extends  RuntimeException{
        public  EmptyIntStackException(){}
    }
    //실행 시 예외:스택이 가득 참
    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException(){}
    }
    //생성자
    public Stack1(int Size){
        ptr =0;
        this.Size =Size;

        try{
            stack =new int[Size]; //스택 본체용 배열을 생성
        }catch (OutOfMemoryError e){//생성할 수 없음
            this.Size =0;
        }
    }
    //스택에 x를 푸시
    public int push(int x) throws OverflowIntStackException{
        if(ptr>= Size)
            throw new OverflowIntStackException();
        return stack[ptr++]=x;
    }
    //스택에서 데이터를 팝(꼭대기에 있는 데이터를 꺼냄)
    public int pop() throws EmptyIntStackException{
        if(ptr<=0) throw new EmptyIntStackException();
        return stack[--ptr];
    }
    public int peek() throws EmptyIntStackException{
        if(ptr<=0)
            throw new EmptyIntStackException();
        return stack[ptr-1];
    }
    public void clear(){
        ptr=0;
    }
    public int indexOF(int x){
        for(int i=ptr-1;i>=0;i--) // 꼭대기 쪽부터 선형 검색
            if(stack[i]==x){
                return i; //검색 성공
            }
        return -1;  //검색 실패
    }
    public int getSize(){
        return Size;
    }
    public int size() {
        return ptr;
    }
    public boolean isEmpty(){
        return ptr<=0;
    }
    public boolean isFull() {
        return ptr>= Size;
    }
    //스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump() {
        if(ptr<=0)
            System.out.println("스택이 비어 있습니다.");
        else{
            for(int i=0; i<ptr; i++)
                System.out.println(stack[i]+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack1 stack =new Stack1(64);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
