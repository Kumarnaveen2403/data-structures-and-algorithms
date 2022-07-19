class Solution {
    public int majorityElement(int[] nums) {
        int me = nums[0];
        int count = 1;
        
        for(int i = 0; i < nums.length; i++){
            if(me != nums[i]){
                if(count == 1){
                    me = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            } else {
                count++;
            }
        }
    
        return me;
    }
}