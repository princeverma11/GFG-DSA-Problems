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
        List<Integer> ansList = new ArrayList<>();
        for(int i=0 ; i<arr.size() ; i++)
        {
            boolean isValid = true;
            int element = arr.get(i);

            while (element > 0) 
            {
                int ld = element % 10;
                if (ld != 1 && ld != 2 && ld != 3) {
                    isValid = false;
                    break;
                    }
             element = element/10;
            }
             if (isValid) {
                ansList.add(arr.get(i));
            }
        }
       
        
        if (ansList.isEmpty()) {
            ansList.add(-1);
        }
         return ansList;
        

        
        
    }
}