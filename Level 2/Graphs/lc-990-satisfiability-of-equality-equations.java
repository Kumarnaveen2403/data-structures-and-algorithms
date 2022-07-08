class Solution {
    int[] parent;
    int[] rank;
    
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        
        for(int i = 0; i < 26; i++){
            parent[i] = i;
        }
        
        for(String s : equations){
            char c1 = s.charAt(0);
            char c2 = s.charAt(3);
            
            boolean isEqual;
            
            if(s.charAt(1) == '!'){
                isEqual = false;
            } else {
                isEqual = true;
            }
            
            int p1 = find(c1 - 'a');
            int p2 = find(c2 - 'a');

            if(isEqual == true){
                union(p1, p2);
            }
            
        }
        
        for(String s : equations){
            char c1 = s.charAt(0);
            char c2 = s.charAt(3);
            
            boolean isEqual;
            
            if(s.charAt(1) == '!'){
                isEqual = false;
            } else {
                isEqual = true;
            }
            
            int p1 = find(c1 - 'a');
            int p2 = find(c2 - 'a');

            if(isEqual == false){
                if(p1 == p2){
                    return false;
                }
            }
            
        }
        return true;
    }
    
    public void union(int l1, int l2){
        if(rank[l1] < rank[l2]){
            parent[l1] = l2;
        } else if(rank[l2] < rank[l1]){
            parent[l2] = l1;
        } else {
            parent[l1] = l2;
            rank[l2]++;
        }
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}