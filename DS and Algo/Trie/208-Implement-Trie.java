class PrefixTree {

    PrefixTree children[];
    boolean endOfTheWord;

    public PrefixTree() {
        children = new PrefixTree[26];
        endOfTheWord = false;
    }

    public void insert(String word) {
        PrefixTree node = this;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';

            if(node.children[index] == null){
                node.children[index] = new PrefixTree();
            }

            node = node.children[index];
        }

        node.endOfTheWord = true;
    }

    public boolean search(String word) {
        PrefixTree node = this;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';

            if(node.children[index]==null){
                return false;
            }

            node = node.children[index];
        }
        if(node.endOfTheWord==true) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        PrefixTree node = this;

        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';

            if(node.children[index]==null){
                return false;
            }

            node = node.children[index];
        }
        return true;
    }
}
