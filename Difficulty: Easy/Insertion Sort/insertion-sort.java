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

            new Solution().insertionSort(arr);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            // System.out.println();

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends

// see copy notes and see GFG
class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        
        int n = arr.length;
        
        //  Start from the second element (index 1) 
        //  because the first element is already "sorted"
        for(int i=1 ; i<n; i++)
        {
            int key = arr[i]; // Store the current element as 'key' (the element to be inserted)
            
            int j = i-1;  // Start comparing with the previous element (left side of the array)
            
            
            // Move elements of arr[0..i-1] (the sorted part) that are greater than 'key'
            // to one position ahead of their current position
            while(j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j--;
            }
            
            arr[j+1] = key; // Insert the 'key' in its correct position in the sorted part
            
        }
    }
}