class Solution {
    //first generate the initial string by appending 0's n times
    //then take the last n - 1 characters and one by one append all
    // the digits and check if it contains in the set of already visited
    //string. 
    //if it is contained in the already visited strings, then do not explore it further
    //otherwise continue exploring
    //return true if set contains all the possible password strings
    public String crackSafe(int n, int k) {
        HashSet<String> set = new HashSet<>();
        
        StringBuilder initial = new StringBuilder();
        for(int i = 0; i < n; i++){
            initial.append('0');
        }
        set.add(initial.toString());
        
        int lim = (int)Math.pow(k, n);
        dfs(initial, n, k, set, lim);

        return initial.toString();
    }
    
    public boolean dfs(StringBuilder sb, int n, int k, HashSet<String> set, int lim){
        if(set.size() == lim ){      
            return true;
        }
        
        String nm1 = sb.substring(sb.length() - (n -1));
        
        for(int i = 0; i <= k - 1; i++){
            String nstr = nm1 + i;
                        
            if(!set.contains(nstr)){
                set.add(nstr);
                sb.append(i);
                
                boolean flag = dfs(sb, n, k, set, lim);
                
                if(flag){
                    return true;
                }
                
                sb.deleteCharAt(sb.length() - 1);
                set.remove(nstr);
                
            }
            
        }
        
        return false;
        
    }
}