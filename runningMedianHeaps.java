import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
/*
	 * useful hint......
	 *
	 * I'll give you guys a hint. You need a min-heap and a max-heap.

Min-heap will contain the maximum half of the numbers from the array. Max-heap will contain the minimum half of the numbers from the array.

So the top value from the min-heap will be the minimum number from the max half of the array. The top value from the max-heap will be the maximum number from the min half of the array.

So you pretty much have the middle values of the array, therefore can calculate the median. So think about it, what can you change to make it work with odd number of values?

*/
    static class maxPQComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b){
            return -1*a.compareTo(b);
        }
    }

    public static PriorityQueue<Integer> leftMaxPQ; 
    public static PriorityQueue<Integer> rightMinPQ;
    
    public static double getRunningMedian(int[] arr,int elementCount, int arrSize, int arrCurrentIndex){
        
        double result = 0.0;
        
        if( leftMaxPQ.size() == 0 || arr[arrCurrentIndex] < leftMaxPQ.peek() ){
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
        
        return result;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int count = 0;
        
         leftMaxPQ = new PriorityQueue<Integer>(n, new maxPQComparator());
         rightMinPQ = new PriorityQueue<Integer>(n);
        
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            count++;
            System.out.println(getRunningMedian(a,count, n, a_i));

        }

    }
}



