public class main{
    public static void main(String args[]){
        Trie trie = new Trie();

        // Insert words
        trie.insert("cat");
        trie.insert("car");
        trie.insert("care");
        trie.insert("dog");


        System.out.println("===== SEARCH OPERATION =====");
        System.out.println("cat : " + trie.search("cat"));
        System.out.println("car : " + trie.search("car"));
        System.out.println("cargo : " + trie.search("cargo"));
        System.out.println("dog : " + trie.search("dog"));
        System.out.println("ca : " + trie.search("ca"));

        System.out.println("===== PREFIX SEARCH =====");
        System.out.println("ca : " + trie.isStartsWith("ca"));
        System.out.println("cac : " + trie.isStartsWith("cac"));
        System.out.println("da : " + trie.isStartsWith("da"));
    }
}