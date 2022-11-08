package Stack;
/*
boolean empty()	Stack이 비어있는지 확인

Object peek()	Stack의 맨 위에 저장된 객체를 반환
pop()과 달리 Stack에서 객체를 꺼내지 않음
비었을 때는 EmptyStackException 반환

Object pop()	Stack의 맨 위에 저장된 객체를 꺼냄
비었을 때는 EmptyStackException 반환

Object push(Object item)	Stack에 객체(item)을 저장

int search(Object o)	Stack에서 주어진 객체(o)를 찾아서 그 위치를 반환
못 찾으면 -1 반환(배열과 달리 위치가 1부터 시작)

 */
public class Stack {
    private int top;  //스택 포인터
    private int Size;//스택 용량
    private Object[] stack; //스택용 배열

    //배열 생성, 스택 생성
    public Stack(int Size){
        this.top=-1;
        this.Size=Size;
        this.stack = new Object[Size];

    }

    //스택 객체 넣기
    public void push(Object item){
        if(full()){ throw new ArrayIndexOutOfBoundsException();}
        stack[++top] =item;
    }
    //스택 객체 빼기
    public Object pop() {
        Object item =peek();
        top--;
        return  item;
    }
    //스택 객체 선택
    public Object peek() {
        if(empty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return stack[top];
    }

    public boolean empty() {
        return (top==-1);
    }
    public boolean full() {
        return (top==Size-1);
    }

    public  static void main(String[] args){
        Stack stack = new Stack(10);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
