class Solution {
    public int search(int[] nums, int target) {
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            
            if(nums[mid] < nums[hi]){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        // lo is at the lowest elements value index
        // lo also signifies the number of rotations
        
        int idx = lo;
        
        int res1 = binarySearch(nums, target, 0, lo - 1);
        int res2 = binarySearch(nums, target, lo, nums.length - 1);
        
        return (res1 > -1 ? res1 : res2);
    }
    
    public int binarySearch(int[] arr, int target, int lo, int hi){
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(arr[mid] < target){
                lo = mid + 1;
            } else if(arr[mid] > target){
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        
        return -1;
    }
}