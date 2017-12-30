import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static long makeChangeWrapper(int[] coins, int money) {
        return makeChange(coins, money, 0, new HashMap<String, Long>());
    }



    //this is recursive,,, also check a iterative solution...
    public static long makeChange(int[] coins, int money, int index, Map<String, Long> cache){
      
       if(money == 0){
           return 1;
       } 
        
        if(money < 0 || index >= coins.length ){
            return 0;
        }
       
        String key = money + "|" + index;
        if(cache.get(key)!= null){
            return cache.get(key);
        }
         
        int moneyLeft = money;
        long result = 0;
       
        while(moneyLeft >= 0){
          
            result += makeChange(coins, moneyLeft, index + 1, cache);  
            moneyLeft = moneyLeft - coins[index]; 
        }
       
        cache.put(key, result);
        
        return result;
        
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChangeWrapper(coins, n));
    }
}

