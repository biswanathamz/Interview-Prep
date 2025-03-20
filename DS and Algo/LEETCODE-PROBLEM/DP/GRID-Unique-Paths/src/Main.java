import java.util.ArrayList;
import java.util.HashMap;

class Grid{
    public static HashMap<String,Integer> memo= new HashMap<>();
    public static int gridTraveler(int m, int n){
        if(m==0 || n==0){
            return 0;
        }
        if(m==1 && n==1){
            return 1;
        }
        if(memo.containsKey(m+"-"+n)){
            return memo.get(m+"-"+n);
        }
        memo.put(m+"-"+n,gridTraveler(m-1,n) + gridTraveler(m,n-1));
        return memo.get(m+"-"+n);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Grid.gridTraveler(3,7));
    }
}