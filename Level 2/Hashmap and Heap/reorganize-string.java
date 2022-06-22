class Solution {
    class Pair implements Comparable<Pair>{
        char ch;
        int count;
        
        Pair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
        
        public int compareTo(Pair other){
            return this.count - other.count;
        }
    }
    
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        PriorityQueue<Pair> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(Character key : map.keySet()){
            queue.add(new Pair(key, map.get(key)));
        }
        
        String sol = "";
        Pair out = null;
        
        while(queue.size() > 0){
            Pair peek = queue.remove();
            
            sol += "" + peek.ch;
            
            peek.count--;
            
            if(out == null){
                out = peek;
            } else {
                if(out.count > 0){
                    queue.add(new Pair(out.ch, out.count));
                }
                
                out = peek;
            }   
        }
        
        if(out.count > 0){
            return "";
        }
        
        return sol; 
    }
}