import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static String YES_STRING = "Prime";
    public static String NO_STRING = "Not prime";
    public static int twoNine = 2000000005;
    public static int sqrtTwoNine = (int)Math.sqrt(twoNine);//be sure you'd need sqrt of n; at places...
    public static boolean[] sieve;
    public static void initializeSieve(){
       
        sieve = new boolean[sqrtTwoNine];    //compositemap
        sieve[0] = true;
        sieve[1] = true;
        for(int n = 2; n < sqrtTwoNine; n++){
            if(!sieve[n]){
               for(int m = n*n; m < sqrtTwoNine; m+=n){
                   sieve[m] = true;
               } 
            }   
        } 
   
    }
    public static String testPrime(int n){
        
       if(n==1) return NO_STRING;
       if(n==2) return YES_STRING;
       for(int a = 2; a*a <= n; a++){
            if((n % a) == 0){
                return NO_STRING;
            }
        }
        return YES_STRING;
    }
    
    public static String testPrimeBetter(int n){
   
       if(n < sqrtTwoNine){
            return sieve[n]?NO_STRING:YES_STRING;
       }
       return testPrime(n);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        
        initializeSieve();
        
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            System.out.println(testPrimeBetter(n));
        }
    }
}
