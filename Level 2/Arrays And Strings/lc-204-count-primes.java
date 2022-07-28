class Solution {
    public int countPrimes(int n) {
        if(n < 2){
            return 0;
        }
        
        boolean[] nums = new boolean[n + 1];
        Arrays.fill(nums, true);
        
        nums[0] = false;
        nums[1] = false;
        
        for(int i = 2; i * i <= n; i++){
            if(nums[i] == true){
                for(int mul = 2; i * mul <= n; mul++){
                    nums[i * mul] = false;
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == true){
                count++;
            }
        }
        
        return count;
    }
}