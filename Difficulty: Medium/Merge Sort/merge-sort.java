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
        // if length ie even the the right middle is choosen
        int m = l+(r-l+1)/2; // note that +1 is done here because anuj 
                             //goes from l to m-1 and m to r whiile calling merSort()
        if(l<r)
        {
            mergeSort(arr, l, m-1);
            mergeSort(arr, m, r);
            merge(arr , l , m , r);
        }
    }
    
    void merge(int[] arr, int l, int m, int r)
    {
        int Lsize = (m-1) - (l) +1;
        int Rsize = r-m+1;
        int[] L = new int[Lsize];
        int[] R = new int[Rsize];
        
        for(int i=0; i<Lsize ; i++)
        {
            L[i] = arr[l+i];
        }
        for(int j=0; j<Rsize ; j++)
        {
            R[j] = arr[m+j];  
        }
        
        int i=0; //for left array
        int j=0; // for right array
        int k=l; // 'l' is the Initial index of merged subarray
        
        while(i<Lsize && j<Rsize)
        {
            if(L[i]<R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while(i<Lsize)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<Rsize)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
        
 
        
    }
    
}
