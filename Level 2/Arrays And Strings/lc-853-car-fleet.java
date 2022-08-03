class Solution {
    class Pair implements Comparable<Pair> {
        int position;
        double reachTime;
        
        Pair(int position, double reachTime){
            this.position = position;
            this.reachTime = reachTime;
        }
        
        public int compareTo(Pair o){
            return this.position - o.position;
        }
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < position.length; i++){
            pq.add(new Pair(position[i], (target - position[i]) * 1.0 / speed[i] ));
        }
        
        int groups = 0;
        double currTime = 0;
        while(pq.size() > 0){
            Pair top = pq.remove();
            if(top.reachTime > currTime){
                currTime = top.reachTime;
                groups++;
            }
        }
        
        return groups;
    }
}