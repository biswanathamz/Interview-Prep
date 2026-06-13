public class Main {
    public static int minEatingSpeed(int[] piles, int hour){
        int left = 1;
        int right = getMaxBananasInAPile(piles);

        while (left<right){
            int mid = left+(right-left)/2;
            if(canIEatInTime(piles,hour,mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static int getMaxBananasInAPile(int[] piles){
        int maxBananas = 0;
        for (int pile : piles){
            maxBananas = Math.max(pile, maxBananas);
        }
        return maxBananas;
    }

    public static boolean canIEatInTime(int[] piles, int hour, int hourlySpeed ){
        int maxHour = 0;
        for(int bananas : piles){
            maxHour += (int) Math.ceil((double) bananas / hourlySpeed);
        }
        return maxHour<=hour;
    }
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 5;
        System.out.println(minEatingSpeed(piles,h));
    }
}