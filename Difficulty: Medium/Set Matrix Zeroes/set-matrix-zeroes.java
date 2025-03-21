//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            new Solution().setMatrixZeroes(arr);
            for (int[] row : arr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution 
{
    public void setMatrixZeroes(int[][] mat) 
    {   
        int[][] matrix = mat;
        int m = matrix.length;
        int n = matrix[0].length;

        int col0 = matrix[0][0];
        for (int i=0 ; i<m ; i++)
        {
            for(int j = 0 ; j<n ; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    if (j == 0)
                        col0 = 0;
                    else
                        matrix[0][j] = 0;
                }
            }
         }


            for(int i=1 ; i<m ; i++)
            {
                for (int j=1 ; j<n ;j++)
                {
                    if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    {
                        matrix[i][j] = 0;
                    }
                }
            }
        
        
            //step 3: Finally mark the 1st col & then 1st row:
            if (matrix[0][0] == 0) 
            {
                for (int t = 1; t < n; t++) 
                {
                    matrix[0][t] = 0;
                }
            }

            if (col0 == 0) 
            {
                for (int l = 0; l < m; l++) 
                {
                    matrix[l][0] = 0;
                }
            }
        
    }
}