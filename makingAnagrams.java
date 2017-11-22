import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
   
        int[] h = new int[26];
        for(int i=0; i<26; i++) h[i] = 0;
        
        for(int i=0; i<first.length(); i++){
            h[first.charAt(i)-(int)'a']++;
        } 
        for(int i=0; i<second.length(); i++){
            h[second.charAt(i)-(int)'a']--;
        }
       
        int result = 0;
        for(int i=0; i<26; i++){
           if(h[i]<0){
               result -= h[i];
           }else{
               result += h[i];
           } 
        }
        return result;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
