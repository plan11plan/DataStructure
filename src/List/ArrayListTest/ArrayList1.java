package List.ArrayListTest;


//리스트를 어떻게 배열을 이용해서 만들 것인가!
public class ArrayList1 {
    // ArrayList는 자바가 알아서 크기를 늘려주지만, 배열은 그렇지 않다. 배열의 크기 정해준건 신경쓰지말자.
    private  Object[] elementData = new Object[100];
    private int size =0; // 배열에 들어간 데이터 개수
    public boolean addFirst(int e){
        size++;
        return add(0,e);
    }

    public boolean addLast(Object element){
      elementData[size]=element;
      size++;
        return true;
    }
    public boolean add(int index,Object element){
        for(int i=size-1;i>=index;i--){
            elementData[i+1]=elementData[i];
        }
        elementData[index] =element;
        size++;
        return true;
    }
    public String toString(){
        String str="[";
        for(int i=0;i<size;i++){
            str+=elementData[i];
            if(i==size-1) continue;
            str+=",";

        }
        return str+"]";
    }
    public boolean remove(int index){
        for(int i=index+1;i<size;i++) {
            elementData[i-1] = elementData[i];
        }
        size--;
         return  true;
    }
    public boolean removeFirst()
    {
        remove(0);
        return true;
    }
    public boolean removeLast()
    {
        remove(size);
        return true;
    }
    public int size(){
        return size;
    }
    public Object get(int index){
        return elementData[index];

    }

    public int indexOf(Object o) {
        for(int i=0;i<size;i++){
            if(o.equals(elementData[i])){
                return i;
            }
        }
        return -1;
    }
    public ListIterator listIterator(){
        return new ListIterator();

    }
    class ListIterator{
        private  int count=0;
        public Object next(){
            return elementData[count++];
        }
        public boolean hasNext(){
            return count<size();
        }
        public Object previous(){
            return elementData[--count];
        }
        public  boolean hasPrevious(){
            return count>0;
        }
        public void add(Object element){
            ArrayList1.this.add(count++,element);
        }
        public void remove(){
            ArrayList1.this.remove(count-1);
            count--;
        }
    }
}
