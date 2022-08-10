class Solution {
    class Pair {
        int idx;
        int val;
        int count;
        
        Pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    
    int[] res;
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        res = new int[nums.length];
        
        Pair[] arr = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = new Pair(i, nums[i]);
        }
        
        mergeSort(arr, 0, nums.length - 1);
        
        for(int count : res){
            ans.add(count);
        }
        
        return ans;
    }
    
    public Pair[] mergeSort(Pair[] arr, int fi, int li){
        if(fi == li){
            Pair[] b = new Pair[1];
            Pair p = new Pair(arr[fi].idx, arr[fi].val);
            b[0] = p;
            return b;
        }
        
        int mid = (fi + li) / 2;
        
        Pair[] fh = mergeSort(arr, fi, mid);
        Pair[] sh = mergeSort(arr, mid + 1, li);
        
        return mergeSorted(fh, sh); 
    }
    
    public Pair[] mergeSorted(Pair[] fh, Pair[] sh){
        Pair[] ans = new Pair[fh.length + sh.length];
        int i = 0, j = 0, k = 0;
        
        while(i < fh.length && j < sh.length){
            if(fh[i].val > sh[j].val){
                res[fh[i].idx] += (sh.length - j);
                
                ans[k] = fh[i];
                i++;
            } else {
                ans[k] = sh[j];
                j++;
            }
            
            k++;
        }
        
        while(i < fh.length){
            ans[k] = fh[i];
            k++;
            i++;
        }
        
        while(j < sh.length){
            ans[k] = sh[j];
            k++;
            j++;
        }
        
        return ans;
    }
}