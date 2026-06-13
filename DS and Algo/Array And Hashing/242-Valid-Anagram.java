import java.util.Arrays;

class main{
    public static boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);

        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);

        String sSorted = new String(sChars);
        String tSorted = new String(tChars);
        if(sSorted.equals(tSorted)) return true;
        return false;
    }
    public static void main(String args[]){
        System.out.println(isAnagram("anagram","nagaraam"));
    }
}