class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lo = 1;
        int hi = Integer.MIN_VALUE;
        
        for(int num : nums){
            hi = Math.max(hi, num);
        }
        
        while(lo < hi){
            int bagSize = (lo + hi) / 2;
            
            int ops = 0;
            
            for(int num : nums){
                if(num > bagSize){
                    ops += (num + bagSize - 1) / bagSize - 1;
                }
            }
            
            
            if(ops > maxOperations){
                lo = bagSize + 1;
            } else {
                hi = bagSize;
            }
        }
        
        return lo;
    }
}