class Node{
    public int key;
    public Node left;
    public Node right;

    public Node(int item){
        this.key = item;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree{
    // Root Node
    Node root;

    public BinarySearchTree(){
        root = null;
    }

    void insert(int key){
        root = insertRec(root,key);
    }

    private Node insertRec(Node node, int key){
        if (node == null){
            node = new Node(key);
        }
        if(key<node.key){
            node.left = insertRec(node.left,key);
        } else if (key>node.key) {
            node.right = insertRec(node.right,key);
        }
        return node;
    }

    void travers(){
        traverseRec(root);
    }

    void traverseRec(Node node){
        if (node!=null){
            traverseRec(node.left);
            System.out.println(node.key);
            traverseRec(node.right);
        }
    }

    boolean search(int key){
        return searchRec(root,key);
    }

    Boolean searchRec(Node node, int key){
        if(node==null||node.key==key){
            return node!=null;
        }
        if(key<node.key){
            return searchRec(node.left,key);
        }
        return searchRec(node.right,key);
    }
}


public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        bst.travers();
        int keyToSearch = 90;
        System.out.println("Searching for key " + keyToSearch + ": " +
                (bst.search(keyToSearch) ? "Found" : "Not Found"));    }
}