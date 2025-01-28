import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamPractice {
    public List<Integer> computeSquares(ArrayList<Integer> arr){
        return arr.parallelStream()
                .map(number -> {
                    System.out.println("Procession Number : "+number+" by Thread : "+Thread.currentThread().getName());
                    return  number*number;
                })
                .collect(Collectors.toList());
    }
}
