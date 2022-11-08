package Queue;

import List.DoublyLinkedListTest.DoublyLinkedList1;

import java.util.LinkedList;
import java.util.Queue;

public class NodeQueue {
    int value; //값을 넣음
    NodeQueue nodeQueue;//다음 노드를 가리킴
    public NodeQueue(int value){
        this.value = value;;
        nodeQueue=null;
    }
    public int getValue(){
        return value;
    }
    public NodeQueue getNextNode(){
        return nodeQueue;
    }
    public void setNextNode(NodeQueue nodeQueue){
        this.nodeQueue=nodeQueue;
    }
    class NodeQueueManager{
        NodeQueue front,rear;
        public NodeQueueManager(){
            front = rear =null;
        }
        public boolean Empty(){
            if(front ==null && rear ==null){
                return true;
            }else{
                return false;
            }
        }
        public void push(int value){
            NodeQueue nodeQueue = new NodeQueue(value);
            if(Empty()){
                front = rear = nodeQueue;
            }else {
                front.setNextNode(nodeQueue);
                front = nodeQueue;
            }
        }
        public NodeQueue pop(){
            if(Empty()){
                System.out.println("Queue is Empty");
                return null;
            }else{
                NodeQueue popNode=rear;
                rear=rear.getNextNode();
                return popNode;
            }
        }
        public NodeQueue peek() {
            if(Empty()){
                System.out.println("Queue is Empty");
                return null;
            }else{
                return  rear;
            }
        }
        public int size() {
            NodeQueue front2 = front;
            NodeQueue rear2=rear;
            int count =0;
            while(front2 != rear2 && rear2 !=null){
                count++;
                rear2 = rear2.getNextNode();
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue);
    }
}
