//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            boolean f = new Solution().isPalindrome(head);

            System.out.println(f ? "true" : "false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/
// o(n)
class Solution {
    // Function to check whether the list is palindrome.
    static boolean isPalindrome(Node head) {

       
       Node middle = findMiddle(head);
       Node headOfReverse = reverseRightPart(middle);
       
       Node t1 = head;
       Node t2 = headOfReverse;
       while(t2!=null)
       {
           if(t1.data!= t2.data)
           {
               return false;
           }
           t1 = t1.next;
           t2 = t2.next;
       }
       return true;

    }
    
    static Node findMiddle(Node head)
    {
         
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
      
    
    }
    static Node reverseRightPart(Node middle)
    {
        Node curr = middle;
        Node after_curr = middle.next;
        Node before_curr = null;
        while(curr!=null)
        {
            curr.next = before_curr;
            
            before_curr = curr;
            curr = after_curr;
            if(after_curr!=null) // If `after_curr` is not null, move it to the next node in the original list
            {
                after_curr = after_curr.next;
            }else{curr = null;} // If `after_curr` is null, set `curr` to null to exit the loop
            
            
        }
        return before_curr;
    }
}
