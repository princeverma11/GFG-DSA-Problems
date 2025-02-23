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

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    void mergeSort(int arr[], int l, int r) {
       
        mergeSortHelper(arr , 0 , arr.length-1);
       
    }
    
    
    
    void mergeSortHelper(int[] arr, int l , int h)
    {
        if(l<h)
        {
            int mid = l + (h-l)/2;
            // Sort first and second halves
            mergeSortHelper(arr, mid+1, h);
            mergeSortHelper(arr, l, mid);
        
            // Merge the sorted halves
            merge(arr, l, mid, h);
        }
       
    }
    
    
    
    
    
    
    
    
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int[] arr, int l, int mid , int h)
    {
        // Find sizes of two subarrays to be merged
        int n1 = mid-l+1;
        int n2 = h-(mid+1)+1;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for(int i=0;i<n1;i++)
        {
            L[i]=arr[l+i];
        }
        for(int i=0;i<n2;i++)
        {
            R[i]= arr[mid+1+i];
        }


        // Initial indices of first and second 
        int i = 0;
        int j = 0;
        int k = l; // Initial index of merged subarray array


        // Merge the temp arrays
        while(i<n1 && j<n2)
        {
            if(L[i]<=R[j])
            {
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while(i<n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Copy remaining elements of R[] if any
        while(j<n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }

    }
}
