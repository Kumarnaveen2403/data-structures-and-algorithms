class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
       
         int max1 = getMax(nums, firstLen, secondLen);
         int max2 = getMax(nums, secondLen, firstLen);

         return Math.max(max1, max2);        
    }
    
    public int getMax(int[] nums, int l1, int l2){
        int max = Integer.MIN_VALUE;
        int[] left = new int[nums.length];
        
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            
            if(i < l1){
                left[i] = sum;
            } else {
                sum -= nums[i - l1];
                left[i] = Math.max(sum, left[i - 1]);
            }
        }
        
        sum = 0;
        int[] right = new int[nums.length];
        
        for(int i = nums.length - 1; i >= 0; i--){
            sum += nums[i];
            
            if(i >= nums.length - l2){
                right[i] = sum;
            } else {
                sum -= nums[i + l2];
                right[i] = Math.max(sum, right[i + 1]);
            }
        }
        
        for(int i = l1 - 1; i < nums.length - l2; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }

        return max;
    }
}