class main{

    public static int minElement(int[] nums) {
        int minElement = Integer.MAX_VALUE;
        for (int num:nums){
            int digitSum = getDigitSum(num);
            minElement = Math.min(digitSum,minElement);
        }
        return minElement;
    }

    public static int getDigitSum(int num){
        int sum = 0;
        while (num>0){
            sum = sum+(num%10);
            num = num/10;
        }
        return sum;
    }

    public static void main(String args[]){
        System.out.println(minElement(new int[] {10,12,13,14}));
    }
}