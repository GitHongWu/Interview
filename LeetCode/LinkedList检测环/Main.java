import java.util.*;

public class Main{

     public static void main(String []args){
         
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n2;
        System.out.println(hasLoop(n1));
        System.out.println("Node start loop: " + findLoopNode(n1).data);
     }
     
    static boolean hasLoop(Node head){

        if(head == null){
            return false;
        }

        Node slow = head, fast = head;
        while (fast != null) {
            
            // make sure fast ptr does not goes to the null.next
            if (fast.next != null) fast = fast.next.next;
            else return false;  // reach to the end of list

            slow = slow.next;

            // loop detected
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    static Node findLoopNode(Node head){
        if(head == null){
            return null;
        }

        Node slow = head, fast = head;
        while (fast != null) {
            
            // make sure fast ptr does not goes to the null.next
            if (fast.next != null) fast = fast.next.next;
            else return null;  // reach to the end of list

            slow = slow.next;

            // loop detected
            if (fast == slow) {
                Node ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}

class Node {
    Node next;
    int data;
    // some user data
    Node(int data){
        this.data = data;
    }
}