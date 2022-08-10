class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long res;
    static long inversionCount(long arr[], long N)
    {
        res = 0;
        mergeSort(arr, 0, arr.length - 1);
        
        return res;
    }
    
    public static long[] mergeSort(long[] arr, int fi, int li){
        if(fi == li){
            long[] b = new long[1];
            b[0] = arr[fi];
            return b;
        }
        
        int mid = (fi + li) / 2;
        long[] fh = mergeSort(arr, fi, mid);
        long[] sh = mergeSort(arr, mid + 1, li);
        
        return mergeSorted(fh, sh);
    }
    
    public static long[] mergeSorted(long[] fh, long[] sh){
        long[] ans = new long[fh.length + sh.length];
        
        int i = 0, j = 0, k = 0;
        
        while(i < fh.length && j < sh.length){
            if(fh[i] <= sh[j]){
                ans[k] = fh[i];
                i++;
                k++;
            } else {
                res += (fh.length - i);
                
                ans[k] = sh[j];
                j++;
                k++;
            }
            
        }
        
        while(i < fh.length){
            ans[k] = fh[i];
            i++;
            k++;
        }
        
        while(j < sh.length){
            ans[k] = sh[j];
            j++;
            k++;
        }
        
        return ans;
    }
}