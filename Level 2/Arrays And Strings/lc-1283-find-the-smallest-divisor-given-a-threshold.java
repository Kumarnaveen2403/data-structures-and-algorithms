class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int hi = Integer.MIN_VALUE;
        int lo = 1;
        
        for(int num : nums){
            hi = Math.max(hi, num);
        }
        
        int res = 0;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            
            int sum = 0;
            for(int num : nums){
                sum += (num + mid - 1)  / mid;
            }
            
            if(sum <= threshold){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
}