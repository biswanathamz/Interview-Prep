import java.util.HashMap;

class Fibonacci{
    public static HashMap<Integer, Integer> memo = new HashMap<>();
    public static int findKthValue(int n){
        if(n<=2){
            return 1;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        memo.put(n,findKthValue(n-1)+findKthValue(n-2));
        return memo.get(n);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Fibonacci.findKthValue(30));
    }
}