//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends

class Solution {

    static int findFloor(int[] arr, int x) {
        
        int l = 0 ;
        int r = arr.length-1;
        
        
        int ansi = -1;
        
        while(l<=r)
        {
            int m = l+(r-l)/2;
            
            if(arr[m] == x)
            {
                ansi = m;
                l = m+1;
            }
            if(arr[m]<x)
            {
                ansi = m;
                l = m+1;
            }
            if(arr[m]>x)
            {
                r = m-1;
            }
        }
        return ansi;
        
    }
}



//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int x = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.findFloor(arr, x);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}

// } Driver Code Ends