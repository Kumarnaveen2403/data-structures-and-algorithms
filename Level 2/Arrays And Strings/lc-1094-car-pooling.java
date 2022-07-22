class Solution {
    class Pair implements Comparable<Pair> {
        int pass;
        int dest;
        
        Pair(int pass, int dest){
            this.pass = pass;
            this.dest = dest;
        }
        
        public int compareTo(Pair o){
            if(this.dest > o.dest){
                return 1;
            } else if(this.dest < o.dest){
                return -1;
            } else {
                if(this.pass < o.pass){
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }
    
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int[] trip : trips){
            pq.add(new Pair( trip[0], trip[1] ) );
            pq.add(new Pair( -trip[0], trip[2] ) );
        }

        int currPassangers = 0;
        
        while(pq.size() > 0){
            Pair top = pq.remove();
            
            currPassangers += top.pass;
            
            if(currPassangers > capacity){
                return false;
            }
        }
        
        return true;
    }
}