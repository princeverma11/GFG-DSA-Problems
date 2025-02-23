//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().quickSort(arr, 0, n - 1);
            printArray(arr);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            
            // pivotIndex is the partition return index of pivot
            int pivotIndex = partition(arr, low, high);

            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
    }
}

    static int partition(int arr[], int low, int high) 
    {
        int pivot = arr[low];
        int i = low;
        int j = high;
        
        while(i<=j)
        {
            while(i<=high && arr[i]<=pivot)
                i++;
            
            while(j>=low && arr[j]> pivot)
                j--;
                
            if(i<j) 
            swap(arr , i , j);    
            
        }
        swap(arr , low , j);
        return j;
        
        
        
    }
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

