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


// } Driver Code Ends

/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/
///////////////////////////////////////////////////////////////////////
// ignore gfg because it solves by O(nsquare)
// anuj ignores even length LL
// thi youtube video is good - https://www.youtube.com/watch?v=xnjwT4sDf8o
///////////////////////////////////////////////////////////////////////


class Solution {
    void reorderlist(Node head) {
        
        Node middle = findMiddle(head);
        
        Node revLLhead = reverseLL(middle.next);
        middle.next = null; // Split the list into two halves
        Node t1 = head;
        Node t2 = revLLhead;
       
       while( t2 != null)
       {
           Node temp_nextoft1 = t1.next;
           Node temp_nextoft2 = t2.next;
           t1.next = t2;
           t2.next = temp_nextoft1;
           
           t1 = temp_nextoft1;
           t2 = temp_nextoft2;
           
           
       }
       
    }
    
    
    static Node findMiddle(Node head)
    {
          Node slow = head ;
          Node fast = head;
    
          while(fast != null && fast.next != null)
          {
             slow = slow.next;
              fast = fast.next.next;
          }
           return slow;   
    }
    static Node reverseLL(Node head)
    {
        if(head ==null || head.next == null) return head;
        Node beforecurr = null;
        Node curr = head;
        Node aftercurr;
        
        while(curr!=null)
        {
            aftercurr = curr.next;//yaha ac aage bd raha h
            
            curr.next = beforecurr;
            
            //moving forward
            beforecurr = curr;
            curr = aftercurr;
            
        }
        return beforecurr;
    }
    
}




















//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            new Solution().reorderlist(head);

            printList(head);
        }
    }
}
// } Driver Code Ends