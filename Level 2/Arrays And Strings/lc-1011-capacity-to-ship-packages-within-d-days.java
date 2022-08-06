class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int hi = 0;
        int lo = Integer.MIN_VALUE;
        
        for(int weight : weights){
            lo = Math.max(lo, weight);
            hi += weight;
        }
        
        while(lo < hi){
            int limit = (lo + hi) / 2;
            
            int count = 1;
            int totalWeight = 0;
            for(int weight : weights){
                if(totalWeight + weight <= limit){
                    totalWeight += weight;
                } else {
                    totalWeight = weight;
                    count++;
                }
            }
            
            if(count > days){
                lo = limit + 1;
            } else {
                hi = limit;
            }
        }
        
        return lo;
    }
}