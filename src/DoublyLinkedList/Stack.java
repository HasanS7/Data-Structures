package DoublyLinkedList;

public class Stack {
    DoublyLinkedList list = new DoublyLinkedList();

    public void push(int num){
        list.addTail(num);
    }

    public int peek(){
        if(list.getSize() > 0){
            return list.getValue(list.getSize() - 1);
        }
        return -1;
    }

    public int pop(){
        if(list.getSize() > 0){
            return list.deleteTail();
        }
        return -1;
    }

    public boolean isEmpty(){
        return list.getSize() <= 0;
    }
}
