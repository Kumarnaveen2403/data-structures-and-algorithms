class Solution {
    public int minMoves2(int[] nums) {
        
        Arrays.sort(nums);
        int midi = nums.length / 2;
        int m = nums[midi];
        
        int ops = 0;
        for(int i = 0; i < nums.length; i++){
            ops += Math.abs(nums[i] - m);
        }
        
        return ops;
    }
}