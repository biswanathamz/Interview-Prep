import java.util.HashMap;

class main{
    public static boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            if(map.containsKey(num)){
                return true;
            }
            map.put(num,1);
        }
        return false;
    }
    public static void main(String args[]){
        System.out.println(hasDuplicate(new int[] {1, 2, 3, 3}));
    }
}