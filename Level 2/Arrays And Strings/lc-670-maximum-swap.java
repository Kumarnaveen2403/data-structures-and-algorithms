class Solution {
    public int maximumSwap(int num) {
        char[] nums = (num + "").toCharArray();
        
        int[] rightMax = new int[nums.length];
        
        int maxIdx = -1;
        int maxVal = Integer.MIN_VALUE;
        for(int i = nums.length -1; i >= 0; i--){
            if(i == nums.length - 1){
                rightMax[i] = -1;
            } else if(i == nums.length - 2){
                rightMax[i] = i + 1;
            } else {
                rightMax[i] = nums[rightMax[i + 1]] >= nums[i + 1] ? rightMax[i + 1] : i + 1;
            }
        }
        
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[rightMax[i]] > nums[i]){
                char temp = nums[i];
                nums[i] = nums[rightMax[i]];
                nums[rightMax[i]] = temp;
                
                break;
            }
        }
        
        return Integer.parseInt(new String(nums));
    }
}