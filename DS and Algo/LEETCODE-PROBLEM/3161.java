import java.util.*;

class main{
    public static List<Boolean> getResults(int[][] queries) {
        for (int[] query:queries){
            for(int i = 0; i<query.length; i++){
                if(i==1){

                }else{
                    
                }
            }
        }
         return Arrays.asList(true, false);
    }

    public static void main(String args[]){
        System.out.println(getResults(new int[][]{
            {1, 2},
            {2, 3, 3},
            {2, 3, 1},
            {2, 2, 2}
        }));
    }
}