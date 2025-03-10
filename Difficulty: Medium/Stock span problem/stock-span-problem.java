//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().calculateSpan(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        
    Deque<Integer> stack = new ArrayDeque<>();
    
    
    ArrayList<Integer> ans = new ArrayList<>();
    // atack.push(0);
    // ans.add(1);
    for(int i = 0 ; i<arr.length ; i++)
    {
         // Pop elements from the stack while the current price is greater than or equal to the price at the index stored in the stack
            while (!stack.isEmpty() && arr[i] >= arr[stack.peekFirst()]) {
                stack.pop();
            }

            // If the stack is empty, the span is (i + 1)
            // Otherwise, the span is (i - stack.peekFirst())
            int span = stack.isEmpty() ? (i + 1) : (i - stack.peekFirst());
            ans.add(span);

            // Push the current index onto the stack
            stack.push(i);
        
    }
            return ans;

    
    }
}