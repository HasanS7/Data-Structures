package DoublyLinkedList;

public class PriorityQueue {
    DoublyLinkedList list = new DoublyLinkedList();

    public void insert(int num){

        int indexToInsert = list.getSize();
        for(int i=0; i<list.getSize(); i++) {
            if(list.getValue((i)) >= num) {
                indexToInsert = i;
                break;
            }
        }

        list.insert(indexToInsert, num);
        return;

    }

    public int remove(){
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

    public void print(){
        list.print();
    }
}
