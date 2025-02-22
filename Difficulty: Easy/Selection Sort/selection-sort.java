//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }

            Solution obj = new Solution();
            obj.selectionSort(a);

            IntArray.print(a);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    void selectionSort(int[] arr) {
        int n = arr.length;
        
        for(int i=0;i<n-1;i++) // -1 because last wala element apni shi position pr hee hoga
        {
            // Assume the current position holds
            // the minimum element
            int min_idx = i;
            
            // Iterate through the unsorted portion
            // to find the actual minimum
            for(int j=i+1;j<n;j++) 
            {
                if (arr[j] < arr[min_idx]) { 
                    // Update min_idx if a smaller element is found
                    min_idx = j;
                }                
            }
            // Move minimum element to its correct position
                int temp = arr[i];
                arr[i] = arr[min_idx];
                arr[min_idx] = temp; 
            
        }
    }
}