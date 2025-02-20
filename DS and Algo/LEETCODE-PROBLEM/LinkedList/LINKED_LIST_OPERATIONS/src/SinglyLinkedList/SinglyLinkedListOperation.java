package SinglyLinkedList;

public class SinglyLinkedListOperation {
    public SinglyListNode append(SinglyListNode head, int data){
        SinglyListNode newNode = new SinglyListNode(data);

        SinglyListNode dummyNode = head;

        while (dummyNode.next!=null){
            dummyNode = dummyNode.next;
        }

        dummyNode.next = newNode;

        return head;
    }

    public void printList(SinglyListNode head){
        SinglyListNode dummyNode = head;
        while (dummyNode.next!=null){
            System.out.print(dummyNode.value);
            System.out.print("→");
            dummyNode = dummyNode.next;
        }
        System.out.print("NULL");
    }
}
