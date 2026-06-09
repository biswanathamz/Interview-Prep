class ListNode{
    public int value;
    public ListNode next;
    public ListNode (int value){
        this.value = value;
        this.next = null;
    }

    public void append(ListNode head, int data){
        ListNode newNode = new ListNode(data);

        ListNode dummyNode = head;

        while (dummyNode.next!=null){
            dummyNode = dummyNode.next;
        }

        dummyNode.next = newNode;

    }

    public void printList(ListNode head){
        ListNode dummyNode = head;
        while (dummyNode!=null){
            System.out.print(dummyNode.value);
            System.out.print("→");
            dummyNode = dummyNode.next;
        }
        System.out.println("NULL");
    }
}
class main{

     public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
     }

    public static void main(String args[]){
        ListNode node = new ListNode(1);
        node.append(node,2);
        node.append(node,3);
        node.append(node,4);
        node.printList(swapPairs(node));
    }
}
