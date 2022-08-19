class Solution {
    public boolean search(int[] nums, int target) {
        
        int lo = 0, hi = nums.length - 1;
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            
            if(nums[mid] < nums[hi]){
                 hi = mid;
            } else if(nums[mid] > nums[hi]){
                lo = mid + 1;
            } else {
                if(nums[hi] < nums[hi - 1]){
                    lo = hi;
                    break;
                } else {
                    hi--;
                }
            }
        }
        
        boolean left =  binarySearch(nums, 0, lo - 1, target);
        boolean right = binarySearch(nums, lo, nums.length - 1, target);
        
        return left || right;
        
    }
    
    boolean binarySearch(int[] nums, int lo, int hi, int target){
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(nums[mid] == target){
                return true;
            } else if(nums[mid] < target){
                lo = mid + 1;
            } else if(nums[mid] > target){
                hi = mid - 1;
            }
        }
        
        return false;
    }
}