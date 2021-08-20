package LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addHead(int num){//O(1)

        Node newNode = new Node(num);

        if(head != null)
            newNode.nextNode = head;
        head = newNode;
        size++;

        if(tail == null)
            tail = head;
    }

    public void addTail(int num){//O(1)
        if(head == null) {
            addHead(num);
            return;
        }

        Node newNode = new Node(num);
        tail.nextNode = newNode;
        tail = newNode;
        size++;
    }

    public void insert(int index, int num) {//O(n)
        if (index > size) {
            return;
        }

        if (index == 0) {
            addHead(num);
            return;
        }

        if (index == size){
            addTail(num);
            return;
        }

        Node currentNode = head;
        for(int i = 0; i < index - 1; i++){
            currentNode = currentNode.nextNode;
        }
        Node newNode = new Node(num);
        Node nextNode = currentNode.nextNode;
        currentNode.nextNode = newNode;
        newNode.nextNode = nextNode;
        size++;
    }

    public int deleteHead(){//O(1)
        int value = head.value;
        Node nextNode = head.nextNode;
        head.nextNode = null;
        head = nextNode;
        size--;
        return value;
    }

    public int deleteTail(){//O(n)
        if(size == 0){
            throw new IndexOutOfBoundsException();
        }

        int value = tail.value;
        Node currentNode = head;
        for(int i = 0; i < size - 2; i++){
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = null;
        tail = currentNode;
        size--;
        return value;
    }

    public boolean contains(int target){//O(n)
        Node currentNode = head;
        for(int i = 0; i < size; i++){
            if(currentNode.value == target){
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    public int indexOf(int target){//O(n)
        Node currentNode = head;
        for(int i = 0; i < size; i++){
            if(currentNode.value == target){
                return i;
            }
            currentNode = currentNode.nextNode;
        }
        return -1;
    }

    public int deleteAt(int index){//O(n)
        if(index == 0){
            return deleteHead();
        }

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = head;
        for(int i = 0; i < index - 1; i++){
            currentNode = currentNode.nextNode;
        }
        int value = currentNode.nextNode.value;
        Node nextNode = currentNode.nextNode.nextNode;
        currentNode.nextNode = null;
        currentNode.nextNode = nextNode;
        size--;
        return value;
    }

    public int getValue(int index){//O(n)
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = head;
        for(int i = 0; i < index; i++){
            currentNode = currentNode.nextNode;
        }
        return currentNode.value;
    }

    public void reverse(){
        Node previousNode = null;
        Node currentNode = head;
        Node nextNode;
        while(currentNode != null){
            nextNode = currentNode.nextNode;
            currentNode.nextNode = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        Node headNode = head;
        head = tail;
        tail = headNode;
    }

    public int getSize(){
        return size;
    }

    public void print(){//O(n)
        Node currentNode = head;

        while(currentNode != null){
            System.out.println(currentNode.value);
            currentNode = currentNode.nextNode;
        }
    }
}