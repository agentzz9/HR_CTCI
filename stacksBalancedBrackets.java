import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    
    public static boolean isOpeningBrace(String s){
        return (s.equals("{") || s.equals("[") || s.equals("(") );
    }
   
    public static boolean isClosingBrace(String s){
        return (s.equals("}") || s.equals("]") || s.equals(")") );
    }
    
    public static boolean isMatchingClosingBrace(String in, String brace){
        boolean result = false;
        switch(in){
            case "[":
                result = brace.equals("]") ;
                break;
            case "{":
                result = brace.equals("}") ;
                break;
            case "(":
                result = brace.equals(")") ;
                break;
        }
        return result;
    }
    
    public static boolean isMatchingOpeningBrace(String in, String brace){
        boolean result = false;
        switch(in){
            case "]":
                result = brace.equals("[") ;
                break;
            case "}":
                result = brace.equals("{") ;
                break;
            case ")":
                result = brace.equals("(") ;
                break;
        }
        return result;
    }
    
    
    public static boolean isBalanced(String expression) {
        boolean result = true;
        Stack<String> stack = new Stack<>();
        //this is embarassaing , dude, use Stack< Character > next time... learn some java dude :(

         
        int i;
        for(i = 0; i < expression.length(); i++){
         String current = expression.substring(i, i + 1);
            //maybe taking char n tostring better? or use buffer or somethin?many strs :( 
            //System.out.println(current);

            if(isOpeningBrace(current)){
               
                stack.push(current);             
            
            }
            else if(!stack.empty()){
          
                if(isMatchingClosingBrace(stack.peek(), current)){   
                    stack.pop(); 
           
                }else{
                   result = false;
                   break;
               }
            }else{
                result = false;
                break;
            }
        
        }
        
        if( !stack.empty() ) result = false;
        
       
       return result; 
        
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
