import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {

	    //interesting nuance of graph class impl. thanks gayle...

        class Node{
            int id;
            List<Integer> neighbors;
            public Node(int id){
                this.id = id;
                neighbors = new LinkedList<Integer>();
            }
        } 
        
        int size;
        Map<Integer, Node> nodeLookup;
        public Graph(int size) {
            nodeLookup = new HashMap<Integer, Node>();
            this.size = size ;
            for(int nodeId = 0; nodeId < this.size; nodeId++){
               nodeLookup.put(nodeId, new Node(nodeId)); 
            }
        }
        public void addEdge(int first, int second) {
           nodeLookup.get(first).neighbors.add(second);
           nodeLookup.get(second).neighbors.add(first);
        }
        
        public int[] shortestReach(int startId) { // 0 indexed.... 
       
            int[] result = new int[this.size];
            for(int i= 0; i<this.size ; i++) result[i] = -1;
            boolean[] visited = new boolean[this.size ];
            
            Queue<Integer> queue = new LinkedList<Integer>();
            
            queue.add(startId);
            visited[startId] = true;
            result[startId] = 0;
            
            while(!queue.isEmpty()){
               int current = queue.peek();
                             queue.poll();
                
               //System.out.println("> "+current);
               for(Integer neighbor : nodeLookup.get(current).neighbors){
                   if(!visited[neighbor]){
                        result[neighbor] = result[current] + 6;
                        queue.add(neighbor);     
                        visited[neighbor] = true;
                   }
               }
            }
            return result;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt()-1;
                int v = scanner.nextInt()-1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt()-1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        scanner.close();
    }
}

