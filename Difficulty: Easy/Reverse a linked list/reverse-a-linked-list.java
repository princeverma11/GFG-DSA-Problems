//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;

            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }

            Solution ob = new Solution();
            head = ob.reverseList(head);
            printList(head);
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// function Template for Java

/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/


//
/////////////////////////
  // watch ANUJ VIDEO to samajh
  //////////
class Solution {
    Node reverseList(Node head) {
        if(head ==null || head.next == null) return head;
        Node curr = head;
        Node after_curr = head.next;
        Node before_curr = null;
        
       
        
        // while(curr!=null)
        // {
        //     curr.next = before_curr;
            
        //     before_curr = curr;
        //     curr = after_curr;
        //     if(after_curr!=null) // If `after_curr` is not null, move it to the next node in the original list
        //     {
        //         after_curr = after_curr.next;
        //     }else{curr = null;} // If `after_curr` is null, set `curr` to null to exit the loop
            
            
        // }
        // return before_curr;
        
        
         while (curr != null) {
            after_curr = curr.next;  // Save the next node
            curr.next = before_curr;  // Reverse the current node's pointer
            
            // Move pointers one step forward
            before_curr = curr;
            curr = after_curr;
        }
         return before_curr;
    }
}



















