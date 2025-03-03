//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends

/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/
//////////////////////////////////////////////////////////////////
// anuj ne jo code bataya usme space 
//complexity zyada aarhi and gfg wale m space complexy O(1) 
//aarhi because gfg wale resilt ko badi wali LL m store krde rhe h

// coding shuttle ki video refer kr skte h bas result store kro in longer LL

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        num1 = trimLeadingZeros(num1);
        num2 = trimLeadingZeros(num2);
        
        
         // Find the length of both the linked lists
        int len1 = countNodes(num1);
        int len2 = countNodes(num2);
        
        // If num1 is smaller, swap the two linked lists by
        // calling the function with reversed parameters
        if (len1 < len2) {
            return addTwoLists(num2, num1);
        }
        
        Node rnum1 = reverseLL(num1); //now se know rnum1 is the linked list of longer length
        Node rnum2 = reverseLL(num2);
        
        Node res = rnum1; //kyuki rnum1 is longer
        
        Node d1 = rnum1 , d2 = rnum2; // d represents digit
        int carry =0;
        
        while(d2 != null || carry!= 0)
        {
            // Add carry to d1
            d1.data += carry;
            
            if(d2!=null)   // If d2 is not empty, add it to d1
            {
                d1.data += d2.data;
                d2 = d2.next;
            }

         // Store the carry for the next nodes
        carry = d1.data / 10;
        
        // Store the remainder in num1
        d1.data = d1.data % 10;
        
        // If we are at the last node of d1 but carry is
        // still left, then add a new node to d1
        if (d1.next == null && carry != 0) 
        {
            d1.next = new Node(0);
        }
        d1 = d1.next;        
        }
        
        // Reverse the resultant linked list to get the
        // required linked list
        return reverseLL(res);
        
        
    }
    
    
    
    
    
    static Node reverseLL(Node head)
    {
        Node curr = head;
        Node after_curr = head.next;
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
    
    
    
    
    
    
    
    
    static int countNodes(Node head) 
    {
        int len = 0;
        Node curr = head;

        while (curr != null) {
            len += 1;
            curr = curr.next;
        }
        return len;
    }






    static Node trimLeadingZeros(Node head)
    {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }











}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends