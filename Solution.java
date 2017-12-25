import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {

    static class maxPQComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b){
            return ((Integer)(-1*(int)a)).compareTo((Integer)(-1*(int)b));
        }
    }

    public static PriorityQueue<Integer> leftMaxPQ; 
    public static PriorityQueue<Integer> rightMinPQ;
    public static double prevMedian;
    public static double getRunningMedian(int[] arr,int elementCount, int arrSize, int arrCurrentIndex, 
                                                                                        double prevMedian){
        
        
        double result = 0.0;
        
        if(arr[arrCurrentIndex] < prevMedian){
            leftMaxPQ.add(arr[arrCurrentIndex]);	
        }else{
             rightMinPQ.add(arr[arrCurrentIndex]);
        }
       
        if(Math.abs(leftMaxPQ.size() - rightMinPQ.size()) == 2){
            if(leftMaxPQ.size() > rightMinPQ.size()) rightMinPQ.add(leftMaxPQ.poll());
            else leftMaxPQ.add(rightMinPQ.poll());
        }
        
        if(elementCount%2 == 0){
           result = (leftMaxPQ.peek() + rightMinPQ.peek())/2.0; 
        }else result = (leftMaxPQ.size() > rightMinPQ.size()) ? 
                        (double)leftMaxPQ.peek() : (double)rightMinPQ.peek();
        
        prevMedian = result;

        return result;


    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int count = 0;
        
         leftMaxPQ = new PriorityQueue<Integer>(n, new maxPQComparator());
         rightMinPQ = new PriorityQueue<Integer>(n);
        prevMedian = 0.0;
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            count++;
            System.out.println(getRunningMedian(a,count, n, a_i, prevMedian));

        }

    }
}




