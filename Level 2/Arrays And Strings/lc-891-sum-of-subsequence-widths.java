class Solution {
    public int sumSubseqWidths(int[] nums) {
        long MOD = 1000000007L;
        Arrays.sort(nums);
        
        long pow = 1;
        int i = 0, j = nums.length - 1;
        long sum = 0;
        
        while(i < nums.length && j >= 0){
            
            sum = (sum + (nums[i] * pow) - (nums[j] * pow)) % MOD;
            
            pow = (pow * 2 ) % MOD; 
            i++;
            j--;
        }
                    
        return (int)sum;
    }
}