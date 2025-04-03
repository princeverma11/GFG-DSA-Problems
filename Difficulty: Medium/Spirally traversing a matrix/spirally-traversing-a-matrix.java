//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



// see leetcode code  - i solved it there
class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        ArrayList<Integer> ans = new ArrayList<>(); 
        
        int m = mat.length;
        if (m == 0) return ans;
        int n = mat[0].length;
        
        int top = 0;
        int left = 0;
        int right = n-1;
        int bottom = m-1;

        while(top <= bottom && left <= right) {
            // Traverse from left to right on top row
            for(int i = left; i <= right; i++) {
                ans.add(mat[top][i]);
            }
            top++;
            
            // Traverse from top to bottom on right column
            for(int i = top; i <= bottom; i++) {
                ans.add(mat[i][right]);
            }
            right--;
            
            // If there are remaining rows, traverse from right to left on bottom row
            if (top <= bottom) {
                for(int i = right; i >= left; i--) {
                    ans.add(mat[bottom][i]);
                }
                bottom--;
            }
            
            // If there are remaining columns, traverse from bottom to top on left column
            if (left <= right) {
                for(int i = bottom; i >= top; i--) {
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}