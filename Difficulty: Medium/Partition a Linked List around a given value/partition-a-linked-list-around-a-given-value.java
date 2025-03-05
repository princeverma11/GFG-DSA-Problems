//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            int x = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            Node res = ob.partition(head, x);
            printList(res);
            System.out.println();
        
System.out.println("~");
}
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

///////////////////////////////////////////////////////////////////////////////
// If you combine nodes equal to x and nodes greater than x 
// into a single list, you lose the ability to maintain the relative 
// order of nodes equal to x and nodes greater than x



// Additionally, the large list's tail (lTail) might still be pointing to some node, 
// which can cause a cycle in the linked list. 
// You need to ensure that the lTail.next is set to null to avoid any cycles.

class Solution {
    public static Node partition(Node node, int x) {
       Node head = node ;
       Node small = new Node(-1);
       Node equal = new Node(-1);
       Node large = new Node(-1);
       
       
        Node sHead = small;
        Node sTail = small;
        Node eHead = equal;
        Node eTail = equal;
        Node lHead = large;
        Node lTail = large;
       
       
       
       Node temp = head;
       while (temp != null) {
            if (temp.data < x) {
                sTail.next = temp;
                sTail = sTail.next;
            } else if (temp.data == x) {
                eTail.next = temp;
                eTail = eTail.next;
            } else {
                lTail.next = temp;
                lTail = lTail.next;
            }
            temp = temp.next;
        }
       
       
       
       // Merge the three lists
        sTail.next = eHead.next;
        eTail.next = lHead.next;
        lTail.next = null; // Important to avoid cycles
        
        return sHead.next;
       

    }
}