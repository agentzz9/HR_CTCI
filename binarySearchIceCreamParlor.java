import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class IceCream implements Comparable<IceCream>{
    
    int id;
    int price;
    public IceCream(int id, int price){
       
        this.id = id;
        this.price = price;
    }
        
    @Override
    public int compareTo(IceCream iceCream){
       return ((Integer)price).compareTo((Integer)iceCream.price); 
    }
    
}
public class Solution {
   
    //Array class has its own binarySerach tooo dont forget.... also optimization for search region possible... (1,3,4,5,6,7,9)
    // if 3,7 = 10; 
    // 3 we have.... no need to search on 1,3. invoke on 4..9 the search for 7
    
    public static IceCream binarySearch(int first, int last, List<IceCream> iceCreams, int search, int avoidSelf) {
      
        if(first > last) return null;
       
        int mid = (first+last)/2;
        
        if(iceCreams.get(mid).price == search && iceCreams.get(mid).id != avoidSelf){
            return iceCreams.get(mid); 
        }
        
        if(iceCreams.get(mid).price < search){
            return binarySearch(mid+1, last, iceCreams, search, avoidSelf); 
        }else{
            return binarySearch(first, mid-1, iceCreams, search, avoidSelf); 
        }
        
    }

    public static void main(String[] args) {
        
        int t;
        int n, m;
 
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
       for(int test = 0; test < t; test++) {       
            
            m = in.nextInt();
            n = in.nextInt(); 
            List<IceCream> iceCreams = new ArrayList<>();

            for (int i = 0; i < n; i++)
                iceCreams.add(new IceCream(i+1,in.nextInt()));
       
           Collections.sort(iceCreams);
          
            for(IceCream currentIceCream : iceCreams){
                int diff = Math.abs(m - currentIceCream.price);
                
                IceCream resultIceCream = binarySearch(0 , n-1, iceCreams, diff, currentIceCream.id);      
               
                if(resultIceCream == null){
                    continue;
                }else{
                    if(currentIceCream.id < resultIceCream.id)
                        System.out.println(currentIceCream.id + " " + resultIceCream.id);            
                    else
                        System.out.println(resultIceCream.id + " " + currentIceCream.id);            
                    
                    break;
                }
                
            } 
       } 
        
    }
                        
}

