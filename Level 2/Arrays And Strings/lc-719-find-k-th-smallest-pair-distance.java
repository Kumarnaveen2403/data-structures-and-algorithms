class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int lo = 0;
        int hi = (nums[nums.length - 1] - nums[0]);
        
        for(int i = 0; i < nums.length - 1; i++){
            lo = Math.min(lo, nums[i + 1] - nums[i]);
        }
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            
            int smaller = 0;
            int i = 0, j = 0;
            while(i < nums.length){
                while(j < nums.length && (nums[j] - nums[i]) <= mid){
                    j++;
                }
                
                smaller += (j - i - 1);
                i++;
            }
            
            if(smaller < k){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo;
    }
}