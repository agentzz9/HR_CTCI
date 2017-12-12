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
