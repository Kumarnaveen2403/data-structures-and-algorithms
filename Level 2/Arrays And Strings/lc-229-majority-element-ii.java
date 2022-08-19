class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int me1 = 0;
        int me2 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for(int val : nums){
            if(me1 == val){
                count1++;
            } else if(me2 == val){
                count2++;
            } else if(count1 == 0){
                me1 = val;
                count1++;
            } else if(count2 == 0){
                me2 = val;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int num : nums){
            if(num == me1){
                count1++;
            } else if (num == me2){
                count2++;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        if(count1 > nums.length / 3){
            ans.add(me1);
        }
        
        if(count2 > nums.length / 3){
            ans.add(me2);
        }
        
        return ans;
    }
}