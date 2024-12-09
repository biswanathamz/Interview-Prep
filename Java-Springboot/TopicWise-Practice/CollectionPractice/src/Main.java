import java.util.*;

interface Demo{
    public void demonstrate();
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
}

public class Main {
    public static void main(String[] args) {
//        Demo demoArrayList = new DemoArrayList();
//        demoArrayList.demonstrate();
//        Demo demoLinkedList = new DemoLinkedList();
//        demoLinkedList.demonstrate();
//        Demo demoStack = new DemoStack();
//        demoStack.demonstrate();

        // Stream API Practice
        StreamPractice streamPractice = new StreamPractice();

        ArrayList<Integer> arrayListForEvenNumbers = new ArrayList<>(Arrays.asList(1,4,2,3,7,5,9,11,8,12));
        System.out.println("Finding even number over : "+arrayListForEvenNumbers+" are : ");
        System.out.println(streamPractice.FindEvenNumbers(arrayListForEvenNumbers));

        ArrayList<Integer> arrayListForMaxNumber = new ArrayList<>(Arrays.asList(1,4,2,3,7,5,9,11,8,12));
        System.out.println("Max number over : "+arrayListForMaxNumber+" are : ");
        System.out.println(streamPractice.FindMaxNumber(arrayListForMaxNumber));

        ArrayList<Integer> arrayListForSum = new ArrayList<>(Arrays.asList(1,4,2,3,7,5,9,11,8,12,1));
        System.out.println("Finding sum over : "+arrayListForSum+" are : ");
        System.out.println(streamPractice.FindSum(arrayListForSum));
    }
}