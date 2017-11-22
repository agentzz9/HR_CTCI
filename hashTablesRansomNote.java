import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    String[] magazineWords;
    String[] noteWords;
    
    public Solution(String magazine, String note) {

       magazineMap = new HashMap<String, Integer>();
       noteMap = new HashMap<String, Integer>();
        
        magazineWords = magazine.split("\\s+");
        noteWords = note.split("\\s+");
        
       for( int m_i = 0; m_i < magazineWords.length; m_i++){
          if(magazineMap.get(magazineWords[m_i]) == null){
             magazineMap.put(magazineWords[m_i], 1); 
          }else{
             magazineMap.put(magazineWords[m_i], magazineMap.get(magazineWords[m_i])+1);
          }
       } 
        
        for( int n_i = 0; n_i < noteWords.length; n_i++){
           if(noteMap.get(noteWords[n_i]) == null) {
             noteMap.put(noteWords[n_i], 1); 
          }else{
             noteMap.put(noteWords[n_i], noteMap.get(noteWords[n_i])+1);
          }
       } 
        
        
       
    }
    
    public boolean solve() {
        
        boolean result = true;
      
            //System.out.println(magazineMap);
            //System.out.println(noteMap);
        for( int n_i = 0; n_i < noteWords.length; n_i++){
           String noteWord = noteWords[n_i];
            if( noteMap.get(noteWord) > magazineMap.get(noteWord) ){
               result = false;
                break;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
