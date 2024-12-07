import java.util.*;

interface Demo{
    public void demonstrate();
    public void streamDemonstrate();
}

class DemoArrayList implements Demo {
    // Dynamic resizing
    // Non-Synchronous | Optimized for Single Thread
    // Fast Fail
    ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,3,2));
    @Override
    public void demonstrate(){
        // 1. ArrayList Example
        this.arrayList.add(5);
        this.arrayList.add(1);
        System.out.println("Printing Array List : ");
        this.arrayList.forEach(n-> System.out.println(n));
        this.arrayList.remove(1);
        System.out.println("Printing Array List after removing one element: ");
        this.arrayList.forEach(n-> System.out.println(n));
    }

    @Override
    public void streamDemonstrate(){
    }
}

class DemoLinkedList implements Demo{
    // Non-Synchronous | Optimized for Single Thread.
    // Does not support accessing elements randomly.
    LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("Sunday","Monday"));
    @Override
    public void demonstrate() {
        System.out.println(" Linked List Elements through For Loop : ");
        this.linkedList.forEach(n -> System.out.println(" Element : "+n));
        System.out.println(" Linked List Elements through Iterator : ");
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println(" Element : "+ element);
        }
        System.out.println(" Linked List Elements through List Iterator : ");
        ListIterator<String> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()){
            String element = listIterator.next();
            System.out.println(" Element : "+ element);
        }
    }

    @Override
    public void streamDemonstrate() {

    }
}

class DemoStack implements Demo{
    Stack<Integer> stack = new Stack<>();

    @Override
    public void demonstrate() {
        this.stack.push(1);
        this.stack.push(5);
        this.stack.push(2);

        System.out.println("Stack Elements");
        this.stack.forEach(n -> System.out.println(n));

        System.out.println("POP Operation");
        System.out.println(this.stack.pop());
        System.out.println(this.stack.pop());
    }

    @Override
    public void streamDemonstrate() {

    }
}

public class Main {
    public static void main(String[] args) {
        Demo demoArrayList = new DemoArrayList();
//        demoArrayList.demonstrate();
//        demoArrayList.streamDemonstrate();
        Demo demoLinkedList = new DemoLinkedList();
//        demoLinkedList.demonstrate();
//        demoLinkedList.streamDemonstrate();
        Demo demoStack = new DemoStack();
//        demoStack.demonstrate();
//        demoStack.streamDemonstrate();
    }
}