class Solution {
    public int firstMissingPositive(int[] nums) {
       
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = nums.length + 1;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(Math.abs(nums[i]) < nums.length + 1){
                if(nums[Math.abs(nums[i]) - 1] > 0){
                    nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
                }
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        
        return nums.length + 1;
    }
}