import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,1,1};
        Map<Integer,Integer> map = new HashMap<>();
        int oneCount = 0;
        int finalCount = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]==1){
                oneCount = oneCount+1;
            } else if (arr[i]==0) {
                finalCount = finalCount+oneCount;
            }
        }
        System.out.println(finalCount);
    }
}