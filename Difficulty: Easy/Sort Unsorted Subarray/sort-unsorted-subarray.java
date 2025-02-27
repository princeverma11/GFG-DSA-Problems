//{ Driver Code Starts
import java.io.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public int[] printUnsorted(int[] arr) {
        
        int max_elem = Integer.MIN_VALUE;
        int min_elem = Integer.MAX_VALUE;
        int startIndex=0 ;
        int endIndex=0 ;
        int i=0;
        int[] ans = new int[2];
        
        for( i=0 ; i<arr.length-1 ; i++)
        {
            if(arr[i]>arr[i+1])
            {
                startIndex = i;
                break;
            }
        }
        if(i == arr.length-1)
        {
            ans[0]=0;
            ans[1]=0;
            return ans;
        }
        
        for( i=arr.length-1 ; i>0 ; i--)
        {
            if(arr[i]<arr[i-1])
            {
                endIndex = i;
                break;
            }
        }
        
        for( i=startIndex ; i<=endIndex ; i++)
        {
            if(arr[i]<min_elem)
            {
                min_elem = arr[i];
            }
            if(arr[i]>max_elem)
            {
                max_elem = arr[i];
            }
        }
        
        for( i=0 ; i<startIndex ; i++)
        {
            if(arr[i]>min_elem)
            {
                startIndex = i;
                break;
            }
        }
        for( i=arr.length-1 ; i>endIndex ; i--)
        {
            if(arr[i]<max_elem)
            {
                endIndex = i;
                break;
            }
        }
        
        
        ans[0] = startIndex;
        ans[1] = endIndex;
        return ans;
    }
}


//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline

        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            int[] ans = solution.printUnsorted(arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends