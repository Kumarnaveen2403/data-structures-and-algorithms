class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] left = new int[nums.length];
        
        int p = 1;
        for(int i = 0; i < nums.length; i++){
            left[i] = p;
            p *= nums[i];
        }
        
        int[] ans = new int[nums.length];
        p = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            ans[i] = p * left[i];
            p *= nums[i];
        }
        
        return ans;
    }
}