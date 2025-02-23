import SinglyLinkedList.SinglyLinkedListOperation;
import SinglyLinkedList.SinglyListNode;

public class Main {
    public static void main(String[] args) {
        // SinglyLinkedListOperation
            // Head Node Create
        SinglyListNode head = new SinglyListNode(1);
        SinglyLinkedListOperation operation = new SinglyLinkedListOperation();
            // Adding node at last
        operation.append(head,2);
        operation.append(head,3);
        operation.append(head,4);
        operation.append(head,5);
        operation.append(head,6);
        operation.append(head,7);
        operation.append(head,8);
            // Traversing and Printing Linked List
        operation.printList(head);
            // Deleting Nth Node From Last
        operation.deleteNthNodeFromLast(head,3);
            // Traversing and Printing Linked List
        operation.printList(head);
    }
}