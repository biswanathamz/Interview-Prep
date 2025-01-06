public class Employee {
    public String name;

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int salary;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
    Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
}
