class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        
        int i = 0, j = m - 1;
        int ans = Integer.MAX_VALUE;
        
        while(j < a.size()){
            ans = Math.min(ans, a.get(j) - a.get(i));
            i++;
            j++;
        }
        
        return ans;
    }
}