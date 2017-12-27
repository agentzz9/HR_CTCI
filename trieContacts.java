import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//little cluttered implementation... keep in mind some better references which implement clearer...
//
class Trie{
    
    //trie-node
    class Node{
        char data;
        Map<Character, Node> childrenLookup;
        boolean isLeaf;
        boolean isWordEnd;
        int wordsAfter;

        Node(char c){
            this.data = c;
            this.childrenLookup = new HashMap<Character, Node>();
            this.isLeaf = true;
            this.wordsAfter = 0;
            
            this.isWordEnd = false;//just a sensible default...
        }
        
        public Node getChild(char key){
            return childrenLookup.get(key);
        }
        
        public void putChild(char key){
             childrenLookup.put(key, new Node(key));
             this.isLeaf = false;
             //this.wordsAfter++;
            
        }
        
    }//end of class Node
    
    Node rootNode;
    Trie(){
        this.rootNode = new Node('*');
    }
    
    public void add(String str){
        
        Node temp = rootNode;
        int i = 0;
        while(i < str.length())
        {
            char currChar = str.charAt(i);
            
            if(temp.getChild(currChar) != null) {
                temp.wordsAfter++;
                temp = temp.getChild(currChar); //currently existing characters...
            }
                
            else break; //reached leave... now we append the rest below....
      
            i++;
        }
        //below loop can be refactored above.. will do later..
        while( i < str.length()){
            char currChar = str.charAt(i);
            
            temp.putChild(currChar);
            temp.wordsAfter++;
            temp = temp.getChild(currChar);
            
            i++;
        }
        temp.isWordEnd = true;
        
    }
    
    public int find(String partStr){
        Node temp = rootNode;
        
        int i=0;
        while(i < partStr.length()){
            char currChar = partStr.charAt(i);
            
            if(temp.getChild(currChar) != null) {
                temp = temp.getChild(currChar); 
            }else {
                return 0;
            }
            
            i++;
        }
       
        if(temp.isWordEnd) return temp.wordsAfter + 1;
        else return temp.wordsAfter;
        
    }
    
   
}//end of Trie class

public class Solution {

    
    
    public static Trie trie = new Trie();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
      
       for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            switch(op){
                case "add":
                    trie.add(contact);
                    break;
                case "find":
                    System.out.println(trie.find(contact));
                    break;
            }
           
           //System.out.println(">> "+trie.rootNode.wordsAfter);
        }
       
    }
}

