public class Trie{
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){

        TrieNode current = root;

        for (char ch : word.toCharArray()){
            int index = ch - 'a';

            if(current.chindren[index]==null){
                current.chindren[index] = new TrieNode();
            }

            current = current.chindren[index];
        }

        current.endOfTheWord = true;
    }

    public boolean search (String word){
        TrieNode current = root;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            
            if(current.chindren[index] == null){
                return false;
            }

            current = current.chindren[index];
        }      

        return current.endOfTheWord;
    }

    public boolean isStartsWith(String word){
        TrieNode current = root;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            
            if(current.chindren[index] == null){
                return false;
            }

            current = current.chindren[index];
        }      

        return true;
    }
}