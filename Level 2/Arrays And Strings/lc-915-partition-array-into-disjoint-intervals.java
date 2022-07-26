class Solution {
    public int partitionDisjoint(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pmax = nums[0];
        int pidx = 0;
        
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            
            max = Math.max(max, num);
            
            if(num < pmax){
                pidx = i;
                pmax = max;
            }
            
        }
        
        return pidx + 1;
    }
}