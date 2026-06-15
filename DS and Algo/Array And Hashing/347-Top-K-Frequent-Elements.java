import java.util.*;
class main{
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
           freq.put(num, freq.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue() - b.getValue()
        );

        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            pq.offer(entry);

            if(pq.size() > k){
                pq.poll();
            }
        }


        int[] result = new int[k];
        for(int i = 0; i<=(k-1); i++){
            result[i] = pq.poll().getKey();
        }

        return result;
    }

    public static void main(String args[]){
        System.out.println(Arrays.toString(topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2)));
    }
}