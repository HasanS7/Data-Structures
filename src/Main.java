import LinkedList.LinkedList;

public class Main {
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.addTail(1);
        list.addTail(2);
        list.addTail(3);
        list.addTail(4);
        list.addTail(5);
        list.addTail(6);
        list.addTail(7);
        list.addTail(8);
        list.addTail(9);
        list.addTail(10);
        list.addTail(11);
        list.addTail(12);
        list.addTail(13);
        list.addTail(14);
        list.addTail(15);
        list.addTail(16);
        list.addTail(17);
        list.addTail(18);
        list.print();
        System.out.println("______________________________________________");
        list.reverse();
        list.print();
    }
}
