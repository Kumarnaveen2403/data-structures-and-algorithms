public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // write your code here

        int j = 0;
        int countz = 0;
        int max = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                countz++;
            }

            while(countz > 1 && j < i){
                if(nums[j] == 0){
                    countz--;
                }

                j++;
            }

            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}