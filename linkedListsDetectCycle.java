/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
   
    boolean result = false;
    if(head == null || head.next == null){
        return false;
    }
    
    Node slowNode = head;
    Node fastNode = head.next; 
    
    while( fastNode != null ){
       if( fastNode == slowNode){
          result = true;
           break;
       } 
       slowNode = slowNode.next;
       fastNode = fastNode.next;
       if(fastNode == null){
           break;
       }else if(fastNode == slowNode){
            result = true;
           break;
       }else{
           fastNode = fastNode.next;
       } 
    }
    
   return result; 

}