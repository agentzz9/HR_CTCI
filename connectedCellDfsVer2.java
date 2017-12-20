import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  
    static int[] dR = {+0, +1, +1, +1, +0, -1, -1, -1}; 
    static int[] dC = {+1, +1, +0, -1, -1, -1, +0, +1};
    
    static boolean[][] visited;//  = new boolean[r][c];

    //alternate : 
    //to save space on visited. we could just clear up matrix of the 1s instead. becasue we anyway dont need to revisit those cells...
   // hence no visited grid needed in this case... 
   // thanks gayle...
    
    public static int getRegionCount(int currRow, int currCol, int[][] matrix, int r, int c, boolean[][] visited){
		       
        int count = 0;
       visited[currRow][currCol] = true;
       count++;
        
        for(int i = 0 ; i< 8; i++){
            
            int nextR = currRow + dR[i];
            int nextC = currCol + dC[i];
        
            if(nextR < r && nextR >= 0 && nextC < c && nextC >= 0 && matrix[nextR][nextC] == 1 && !visited[nextR][nextC]){
                visited[nextR][nextC] = true;
                count += getRegionCount(nextR, nextC, matrix, r, c, visited); 
            }
            
        }
        return count;
        
    }
    
    public static int getBiggestRegion(int[][] matrix, int r, int c) {
       
        int count = 0, maxCount = Integer.MIN_VALUE;
         visited = new boolean[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(matrix[i][j]==1 && !visited[i][j]){
                    count = getRegionCount(i, j, matrix, r, c, visited);         
                    maxCount = (count>maxCount)?count:maxCount;
                    count = 0;
                }
            }
        }
        return maxCount;
        
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid, n, m));
    }
}


