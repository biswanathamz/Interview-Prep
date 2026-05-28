class TrieNode{
    TrieNode[] chindren;
    boolean endOfTheWord;

    public TrieNode(){
        chindren = new TrieNode[26];
        endOfTheWord = false;
    }
}