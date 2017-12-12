import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();
        Stack<T> stackTemp;
       
        public void fillOldestToNewest(){
            while(!stackOldestOnTop.empty()){
                stackNewestOnTop.push( stackOldestOnTop.pop() );
            }
        }
        
        public void fillNewestToOldest(){
            while(!stackNewestOnTop.empty()){
                stackOldestOnTop.push( stackNewestOnTop.pop() );
            }
        }
        
        public void swapOldNewStacks(){
            stackTemp = stackOldestOnTop;
            stackOldestOnTop = stackNewestOnTop;
            stackNewestOnTop = stackTemp;
        }
        
        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
         
            T result = null;
        
            if(stackOldestOnTop.empty()){
                fillNewestToOldest();
            }
            
            result = stackOldestOnTop.peek();
            
            return result;
        }

        public T dequeue() {
 
            T result = null;
        
            if(stackOldestOnTop.empty()){
                fillNewestToOldest();
            }
            
            result = stackOldestOnTop.pop();
            
            return result;
        }
    }

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}