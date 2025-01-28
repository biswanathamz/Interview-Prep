import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
    public final String name;
    public final int roll;
    public final int age;


    Student(String name, int roll, int age){
        this.name = name;
        this.roll = roll;
        this.age = age;
    }

    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", roll=" + roll +
                ", age=" + age +
                '}';
    }

}

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students= new ArrayList<>();
        students.add(new Student("Ram",3,21));
        students.add(new Student("Sham",2,22));
        students.add(new Student("Mohan",4,23));
        students.add(new Student("Komal",1,20));
        students.add(new Student("Pavan",6,25));
        students.add(new Student("Joti",5,21));

        System.out.println("Listing all the Student Details :");
        for(Student st : students){
            System.out.println(st);
        }

        System.out.println("Sorting Students based on their roll number");
        Comparator<Student> rollCom = new Comparator<Student>() {
            public int compare(Student i, Student j) {
                if (i.roll>j.roll)
                    return 1;
                else return -1;

            }
        };
//        Collections.sort(students,rollCom);
        Collections.sort(students,(stu1,  stu2) -> (stu1.roll-stu2.roll));
        for(Student st : students){
            System.out.println(st);
        }
    }
}