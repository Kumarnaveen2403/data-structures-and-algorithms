class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        
        int l = 0, r = nums.length - 1, i = nums.length - 1;
        
        while(i >= 0){
            int ls = nums[l] * nums[l];
            int rs = nums[r] * nums[r];
            
            if(ls > rs){
                ans[i] = ls;
                l++;
            } else {
                ans[i] = rs;
                r--;
            }
            
            i--;
        }
        
        return ans;
    }
}