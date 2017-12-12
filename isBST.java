
boolean checkBST(Node root){
   
    return checkBSTUtil(root,-1,100005);
}
boolean checkBSTUtil(Node root, int minKey, int maxKey){
   
   if(root == null){
       return true;
   } 
   if(root.data < minKey || root.data > maxKey)
       return false;
   
   return ((checkBSTUtil(root.left, minKey, root.data-1)) && (checkBSTUtil(root.right, root.data+1, maxKey)));
}
