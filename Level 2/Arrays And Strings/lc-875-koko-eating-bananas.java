class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int hi = 0;
        int lo = 1;
        
        for(int pile : piles){
            hi = Math.max(hi, pile);
        }
        
        while(lo < hi){
            int k = (lo + hi) / 2;
            
            int hours = 0;
            for(int pile : piles){
                hours += (pile + k - 1) / k;
            }
            
            if(hours > h){
                lo = k + 1;
            } else {
                hi = k;
            }
        }
        
        return lo;
    }
}