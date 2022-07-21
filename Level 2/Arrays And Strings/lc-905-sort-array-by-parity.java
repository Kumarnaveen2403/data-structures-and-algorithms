class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int i = 0, j = 0;
        
        while(i < nums.length && j < nums.length && nums[i] % 2 == 0){
            i++;
            j++;
        }
        
        while(j < nums.length){
            if(nums[j] % 2 == 1){
                j++;
            } else {
                swap(i, j, nums);
                j++;
                i++;
            }
        }
        
        return nums;
    }
    
    public void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}