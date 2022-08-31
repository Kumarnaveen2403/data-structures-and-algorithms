class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int val : nums){
            sum += val;
        }
        
        int tar = 0;
        if(sum % 2 == 0){
            tar = sum / 2;
        } else {
            return false;
        }
        
        boolean[][] dp = new boolean[nums.length + 1][tar + 1];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(j == 0){
                    dp[i][j] = true;
                } else if(i == 0){
                    dp[i][j] = false;
                } else {
                    if(dp[i - 1][j] == true){
                        dp[i][j] = true;
                    } else {
                        int ntar = j - nums[i - 1];
                        
                        if(ntar >= 0){
                            dp[i][j] = dp[i - 1][ntar];
                        }
                    }
                }
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
    }
}