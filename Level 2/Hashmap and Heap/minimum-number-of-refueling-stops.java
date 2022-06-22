class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        int range = startFuel;
        int stops = 0;
        int i = 0;
        
        while(range < target){   
            while(i < stations.length){
                if(stations[i][0] <= range){
                    queue.add(stations[i][1]);
                } else {
                    break;
                }
                
                i++;
            }
            
            if(queue.size() == 0){
                return -1;
            }
            
            range += queue.remove();
            stops++;
        }
        
        return stops;
    }
}