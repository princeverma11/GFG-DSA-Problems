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


class Solution 
{
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int l, int h) 
    {
        if(l<h)
        {
            int ciofe = partition(arr , l , h); //correct_index_of_first_element
            //moreover first element ko uski shi position pr pahocha bhi dega in sorted array
    
            //kyuki woh shi posotion pr pahoch gya h isliye m ab uske left and right part k liye same function call krdunga;
            quickSort(arr , l , ciofe -1 );
            quickSort(arr , ciofe +1 , h );
        }
        
        
    }
        

    static int partition(int arr[], int l, int h) 
    {
        int pivotelem = arr[l];
        int i = l;
        int j = h;
        
        
        while (i<=j)
        {
            while(i<=h && arr[i]<=pivotelem) i++;
            while(j>=l && arr[j]>pivotelem) j--;
            
            if(i<j) swap(arr , i , j);
        }
        swap(arr , l , j);
        
        return j;
        
    }
    
    static void swap(int[] arr , int i , int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
