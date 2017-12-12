import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    public static Map<Integer, Integer> cache = new HashMap<>();
    public static int calculate(int n){
       
        if(cache.get(n) != null){
            return cache.get(n);
        }
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;
        
        int nMinus1 = calculate(n-1);
        int nMinus2 = calculate(n-2);
        int nMinus3 = calculate(n-3);
        
        cache.put(n-1, nMinus1);
        cache.put(n-2, nMinus2);
        cache.put(n-3, nMinus3);
        

	/*
	 * no. of ways till N = no. of ways till N after i took (1) first step +
	 * 			no. of ways teill N after i took (2) first step + 
	 * 			no. of ways till N after i took (3) first step.
	 *
	 * 			(each recurses till we hit basecase of 1,2,3)A
	 */

	//iterative fill array till 1,2,3 ... n also an approach.
	//one more optimization is to circularly maintain the array of 3 as we build up the value till N (cos we dont need n-4, n-5,.... n-n values... )
	
        return (nMinus1 + nMinus2 + nMinus3);
        
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            
            System.out.println(calculate(n));
        }
    }
}
