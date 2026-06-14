import java.util.*;

class main{
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);

            String key = new String (strChars);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String args[]){
        System.out.println(groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"}));
    }
}