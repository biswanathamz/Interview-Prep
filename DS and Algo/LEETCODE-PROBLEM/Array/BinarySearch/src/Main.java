public class Main {

    public static int search(int[] numbers, int element){
        int index = 0;
        if (numbers.length == 0) {
            return index;
        }
        int leftIndex = 0;
        int rightIndex = numbers.length-1;
        while(leftIndex <= rightIndex) {
            int checkIndex = leftIndex+(rightIndex-leftIndex)/2;
            if(element==numbers[checkIndex]){
                return checkIndex;
            }
            if(element<numbers[checkIndex]){
                rightIndex = checkIndex-1;
            }else{
                leftIndex = checkIndex+1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] input = new int[]{26, 34, 41, 48, 59, 95, 118, 121, 143, 147, 170, 199, 205, 217, 260, 306, 347, 364, 450, 456, 463, 473, 489, 490, 494, 512, 544, 561, 580, 586, 600, 604, 626, 629, 687, 704, 712, 750, 763, 798};
        int searchElement = 34;
        int location = search(input,searchElement);
        System.out.println("Element : "+searchElement+((location!=0)?" found at index : "+location:" not found!"));
    }
}