//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends

class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
          int[] nums = arr;
          int l=0;
        int r = nums.length-1;
        int i = 0;
        while(i<=r)
        {
            if(nums[i]==2)
            {
                nums[i] = nums[r];
                nums[r] = 2;
                r--;
            }
            else if(nums[i] == 0)
            {
                nums[i] = nums[l];
                nums[l] = 0;
                l++;
                i++;
            }
            else // nums[i] == 1
            {
                i++;
            }
        }
        
    }
}


//{ Driver Code Starts.
// } Driver Code Ends