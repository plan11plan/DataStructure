package Queue;

public class ArrayQueue {
    int MAX =1000;
    int front; //머리 쪽에 위치할 index값,pop할 때 참조하는 index
    int rear; //꼬리 쪽에 위치할 index값,push할때 참조하는 index
    int [] queue; //생성자에서 만들어줄거임
    public ArrayQueue(){
        front = rear =0; //초기값 0
        queue = new int[MAX]; //배열생성
    }
    public void push(int value){
        if(Full()){
            System.out.println("Queue is FUll");
            return;
        }
        queue[rear++] = value;
        //rear가 위치한 곳에 값을 넣어주고 reaar를
        //증가시킨다
    }
    public int pop(){
        if(Empty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int popValue = queue[front++];
        return popValue;
    }
    public int peek() {
        if(Empty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front];

    }
    public boolean Empty(){
        return front==rear;
    }
    public boolean Full(){
        if(rear==MAX-1){
            return true;
        }else
            return false;
    }
    public  int size() {
        return front-rear;
    }
}
