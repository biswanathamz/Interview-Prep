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
        // Collection Practice
//        Demo demoArrayList = new DemoArrayList();
//        demoArrayList.demonstrate();
//        Demo demoLinkedList = new DemoLinkedList();
//        demoLinkedList.demonstrate();
//        Demo demoStack = new DemoStack();
//        demoStack.demonstrate();

        // Stream API Practice
        StreamPractice streamPractice = new StreamPractice();

        ParallelStreamPractice parallelStreamPractice = new ParallelStreamPractice();

        ArrayList<Integer> arrayListForEvenNumbers = new ArrayList<>(Arrays.asList(1,4,2,3,7,5,9,11,8,12));
        System.out.println("Finding even number over : "+arrayListForEvenNumbers+" are : ");
        System.out.println(streamPractice.FindEvenNumbers(arrayListForEvenNumbers));

        ArrayList<Integer> arrayListForMaxNumber = new ArrayList<>(Arrays.asList(1,4,2,3,7,5,9,11,8,12));
        System.out.println("Max number over : "+arrayListForMaxNumber+" are : ");
        System.out.println(streamPractice.FindMaxNumber(arrayListForMaxNumber));

        ArrayList<Integer> arrayListForSum = new ArrayList<>(Arrays.asList(1,4,2,3,7,5,9,11,8,12,1));
        System.out.println("Finding sum over : "+arrayListForSum+" are : ");
        System.out.println(streamPractice.FindSum(arrayListForSum));

        ArrayList<Integer> arrayListForFindCountOfGreaterThan3000 = new ArrayList<>(Arrays.asList(3000,300,3000,2000,10000,3000));
        System.out.println("Finding count of 3000 over : "+arrayListForFindCountOfGreaterThan3000+" are : ");
        System.out.println(streamPractice.findCountOfGreaterThan3000(arrayListForFindCountOfGreaterThan3000));

        ArrayList<String> varFindStrWhoseLengthGreaterThan3 = new ArrayList<>(Arrays.asList("Birds","Cat","Dog","Elephant"));
        System.out.println("Finding String whose length is more than 3| String List : "+varFindStrWhoseLengthGreaterThan3+" Result is  : ");
        System.out.println(streamPractice.findStrWhoseLengthGreaterThan3(varFindStrWhoseLengthGreaterThan3));

        ArrayList<String> varStringChangeToLower = new ArrayList<>(Arrays.asList("BiRdS","CAT","Dog","ElepHaNt"));
        System.out.println("Converting Strings to lower case| String List : "+varStringChangeToLower+" Result is  : ");
        List<String> resultStr = streamPractice.stringChangeToLower(varStringChangeToLower);
        System.out.println(resultStr);

        ArrayList<String> varFindCountOfEachStartingElement = new ArrayList<>(Arrays.asList("apple", "banana", "avocado", "blueberry", "cherry", "apricot", "carrot","potato","chili"));
        System.out.println("Counting the First letter of each String| String List : "+varFindCountOfEachStartingElement+" Result is  : ");
        System.out.println(streamPractice.findCountOfEachStartingElement(varFindCountOfEachStartingElement));

        ArrayList<Integer> arrayListForParallelSquareOperation = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        System.out.println("Square operation over : "+arrayListForParallelSquareOperation+" are : ");
        System.out.println(parallelStreamPractice.computeSquares(arrayListForParallelSquareOperation));

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Ram",1000));
        employeeList.add(new Employee("Arun",2000));
        employeeList.add(new Employee("Sham",1400));
        employeeList.add(new Employee("Pravin",900));
        System.out.println("Finding second highest salary among"+employeeList+" is : ");
        streamPractice.findSecondHighestSalary(employeeList).ifPresentOrElse(System.out::println,()-> System.out.println("Second Highest Salary not present"));
    }
}