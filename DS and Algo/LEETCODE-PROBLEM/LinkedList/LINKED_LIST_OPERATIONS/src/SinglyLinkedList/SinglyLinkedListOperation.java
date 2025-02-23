package SinglyLinkedList;

public class SinglyLinkedListOperation {

    public void append(SinglyListNode head, int data){
        SinglyListNode newNode = new SinglyListNode(data);

        SinglyListNode dummyNode = head;

        while (dummyNode.next!=null){
            dummyNode = dummyNode.next;
        }

        dummyNode.next = newNode;

    }

    public void printList(SinglyListNode head){
        SinglyListNode dummyNode = head;
        while (dummyNode!=null){
            System.out.print(dummyNode.value);
            System.out.print("→");
            dummyNode = dummyNode.next;
        }
        System.out.println("NULL");
    }

    public void deleteNthNodeFromLast(SinglyListNode head, int n){
        // Tutorial : https://www.youtube.com/watch?v=XVuQxVej6y8
        SinglyListNode dummyNode = new SinglyListNode(0);
        dummyNode.next = head;

        SinglyListNode leftNode = dummyNode;
        SinglyListNode rightNode = head;

        for (int i=0; i<n; i++){
            rightNode = rightNode.next;
        }

        while (rightNode!=null){
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        assert leftNode.next != null;
        leftNode.next = leftNode.next.next;
    }
}
