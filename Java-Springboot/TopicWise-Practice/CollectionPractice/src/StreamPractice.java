import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamPractice {
    public StreamPractice(){

    }

    public List<Integer> FindEvenNumbers(List<Integer> list){
        List<Integer> evenNumbers = new ArrayList<>();
        evenNumbers = list.stream()
                .filter(num -> num%2==0)
                .collect(Collectors.toList());
        return evenNumbers;
    }

    public Integer FindMaxNumber(List<Integer> list){
        return list.stream()
                .max(Integer::compare).get();
    }

    public Integer FindSum(List<Integer> list){
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public long findCountOfGreaterThan3000(ArrayList<Integer> list){
        return list.stream().filter((Integer intVal) -> intVal==3000).count();
    }

    public List<String> findStrWhoseLengthGreaterThan3(ArrayList<String> arr){
        return arr.stream().filter((String str) -> str.length()>3).collect(Collectors.toList());
    }

    public List<String> stringChangeToLower(ArrayList<String> arr){
        return arr.stream().map((String str) -> str.toLowerCase()).collect(Collectors.toList());
    }

    public Map<Character,Integer> findCountOfEachStartingElement(ArrayList<String> arr){
        return arr.stream().collect(Collectors.groupingBy((String str) -> str.charAt(0), Collectors.summingInt(s->1)));
    }

    public Optional<Employee> findSecondHighestSalary(ArrayList<Employee> arr){
        Optional<Employee> secondHighestSalary =  arr.stream()
                .sorted((i,j)->(j.salary-i.salary))
                .distinct()
                .skip(1)
                .findFirst();
        return secondHighestSalary;
    }

}
