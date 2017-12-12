import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long countInversionsSplit(int[] arr, int low, int mid, int high){
     
        int[] tempArr = new int[high - low + 1];
        int index = 0; 
       
        long count = 0;
        
        int leftStart = low;
        int rightStart = mid + 1;
        int leftEnd = mid;
        int rightEnd = high;
        
        while(leftStart <= leftEnd && rightStart <= rightEnd){
           
            if(arr[leftStart] <= arr[rightStart]){
                tempArr[index++] = arr[leftStart++];
                
            }else{
                count += (mid - leftStart + 1);
                tempArr[index++] = arr[rightStart++];
            }
            
        }
        
        while(leftStart<=leftEnd){
            tempArr[index++] = arr[leftStart++];
        }
        while(rightStart<=rightEnd){
            tempArr[index++] = arr[rightStart++];
        }
        
       System.arraycopy(tempArr, 0, arr, low, high - low + 1); 
   
        return count;
    }
    
    
    //piggyback on mergesort routine, because turns out the merging of sorted parts will be able to give us inversions...
    static long countInversions(int[] arr, int low, int high) {
   
       if(low >= high){
          return 0; 
       } 
        else{
   
           int mid = (low+high)/2; 
           long leftCount = countInversions(arr, low, mid);
           long rightCount = countInversions(arr, mid + 1, high);
           long splitCount = countInversionsSplit(arr, low, mid, high);
            
           return splitCount + leftCount + rightCount;
        }
    
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr, 0, n-1);
            System.out.println(result);
        }
        in.close();
    }
}
