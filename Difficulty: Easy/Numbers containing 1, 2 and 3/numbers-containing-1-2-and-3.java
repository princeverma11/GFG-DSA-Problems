//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();

            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Solution ob = new Solution();
            List<Integer> result = ob.filterByDigits(arr);
            if (result.isEmpty()) {
                System.out.println("-1");
            } else {
                for (int x : result) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public List<Integer> filterByDigits(List<Integer> arr) 
    {
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0 ; i<arr.size() ; i++)
        {
            int curr = arr.get(i);
           
            boolean valid = false;
            while(curr != 0)
            {
                int ld = curr%10;
                curr /=10;
                if(ld >=1 && ld<=3)
                {
                    valid = true;
                }
                else
                {
                    valid = false;
                    break;
                }                
            }
            if(valid)
            {
                ans.add(arr.get(i));
               
            }
            
        }
        
        if(ans.isEmpty())
            {
                ans.add(-1);
                return ans;    
            }
        return ans;
    }
}