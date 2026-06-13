// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.HashMap;

class Main {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0; 
        int maxLength = 0;
        for (int right=0; right<s.length(); right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch) && map.get(ch)>=left){
                left = map.get(ch)+1;
            }
            map.put(ch,right);
            maxLength = Math.max(maxLength,(right-left)+1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}