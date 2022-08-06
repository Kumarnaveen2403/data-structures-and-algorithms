class Solution {
    public int splitArray(int[] nums, int m) {
        int hi = 0;
        int lo = Integer.MIN_VALUE;
        
        for(int num : nums){
            lo = Math.max(lo, num);
            hi += num;
        }
        
        while(lo < hi){
            int limit = (lo + hi) / 2;
            
            int parts = 1;
            int total = 0;
            for(int num : nums){
                if(total + num <= limit){
                    total += num;
                } else {
                    total = num;
                    parts++;
                }
            }
            
            if(parts > m){
                lo = limit + 1;
            } else {
                hi = limit;
            }
        }
        
        return lo;
    }
}