//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    public List<List<Integer>> threeSum(int[] arr, int target) {
         
        int n = arr.length;
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for(int i=0 ; i<n-2; i++)
        {
            if(i>0 && arr[i] == arr[i-1])
                continue;
            
        int l = i+1;
        int r = n-1;

       

        while(l<r)
        {
           
            
            if(arr[l]+arr[r] == target-arr[i])
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[l]);
                temp.add(arr[r]);
                ans.add(temp);
                l++;
                r--;
                while(l<r && arr[l] == arr[l-1])
                {
                    l++;
                }
                while(l<r && arr[r] == arr[r+1])
                {
                    r--;
                }
            }
            
            if(arr[l]+arr[r]<target-arr[i])
            {
                l++;
            }    
            if(arr[l]+arr[r]>target-arr[i])
            {
                r--;
            }
            
        
        }
    }
    return ans;

    }
}


//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();
            List<List<Integer>> res = obj.threeSum(nums, target);
            Collections.sort(res, (a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });
            if (res.size() == 0) {
                System.out.println("[]");
            }
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends