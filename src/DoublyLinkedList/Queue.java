package DoublyLinkedList;

public class Queue {
    DoublyLinkedList list = new DoublyLinkedList();

    public void enqueue(int num){
        list.addTail(num);
    }

    public int dequeue(){
        if(list.getSize() >= 0){
            return list.deleteHead();
        }
        return -1;
    }

    public int peek(){
        if(list.getSize() >= 0){
            return list.getValue(0);
        }
        return -1;
    }

    public boolean isEmpty(){
        return list.getSize() <= 0;
    }
}
