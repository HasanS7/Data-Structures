package DoublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addHead(int num){ //O(1)
        Node newNode = new Node(num);
        if(head != null){
            newNode.nextNode = head;
            head.previousNode = newNode;
        }
        head = newNode;
        size++;

        if(tail == null)
            tail = head;
    }

    public void addTail(int num){ //O(1)
        if(head == null){
            addHead(num);
            return;
        }

        Node newNode = new Node(num);
        tail.nextNode = newNode;
        newNode.previousNode = tail;
        tail = newNode;
        size++;
    }

    public void insert(int index, int num) { //O(n / 2)
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            addHead(num);
            return;
        }

        if(index == size){
            addTail(num);
            return;
        }

        Node currentNode = head;
        if(index < size/2) {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.nextNode;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index - 1; i--) {
                currentNode = currentNode.previousNode;
            }
        }
        Node newNode = new Node(num);
        Node nextNode = currentNode.nextNode;
        currentNode.nextNode = newNode;
        newNode.previousNode = currentNode;
        nextNode.previousNode = newNode;
        newNode.nextNode = nextNode;
        size++;
    }

    public int deleteHead(){ //O(1)
        if(size == 0){
            return -1;
        }

        int value = head.value;
        Node nextNode = head.nextNode;
        nextNode.previousNode = null;
        head.nextNode = null;
        head = nextNode;
        size--;
        return value;
    }

    public int deleteTail(){ //O(1)
        if(size == 0){
            return -1;
        }

        int value = tail.value;
        Node previousNode = tail.previousNode;
        previousNode.nextNode = null;
        tail.previousNode = null;
        tail = previousNode;
        size--;
        return value;
    }

    public int deleteAt(int index){ //O(n / 2)
        if(index == 0){
            return deleteHead();
        }

        if(index == size - 1){
            return deleteTail();
        }

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = head;
        if(index < size/2) {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.nextNode;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index - 1; i--) {
                currentNode = currentNode.previousNode;
            }
        }
        int value = currentNode.value;
        Node nextNode = currentNode.nextNode;
        currentNode.nextNode = null;
        Node previousNode = currentNode.previousNode;
        currentNode.previousNode = null;
        previousNode.nextNode = nextNode;
        nextNode.previousNode = previousNode;
        size--;
        return value;
    }

    public void print(){ //O(n)
        Node currentNode = head;
        while(currentNode != null){
            System.out.println(currentNode.value);
            currentNode = currentNode.nextNode;
        }
    }

    public int getValue(int index){
        if(index == 0){
            return head.value;
        }

        if(index == size - 1){
            return tail.value;
        }

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = head;
        if(index < size/2) {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.nextNode;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index - 1; i--) {
                currentNode = currentNode.previousNode;
            }
        }
        return currentNode.value;
    }

    public int getSize(){
        return size;
    }
}
