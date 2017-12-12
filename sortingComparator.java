// Write your Checker class here

class Checker implements Comparator<Player>{
   
   
    public int compare(Player o1, Player o2){
       
       int scoreCompare = ((Integer)(o2.score)).compareTo((Integer)(o1.score));
        
        if(scoreCompare != 0){
            return scoreCompare;
        }else{
            return o1.name.compareTo(o2.name);
        }
    }
    
}