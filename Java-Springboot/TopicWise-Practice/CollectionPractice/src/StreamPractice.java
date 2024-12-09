import java.util.ArrayList;
import java.util.List;
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
}
