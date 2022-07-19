class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int i = -1;
        int j = -1;
        
        int res = 0;
        
        for(int idx = 0; idx < nums.length; idx++){
            if(nums[idx] <= right && nums[idx] >= left){
                j = idx;
                res += (j - i);
            } else if(nums[idx] < left){
                res += (j - i); 
            } else if(nums[idx] > right){
                i = idx;
                j = idx;
            }
        }
        
        return res;
    }
}