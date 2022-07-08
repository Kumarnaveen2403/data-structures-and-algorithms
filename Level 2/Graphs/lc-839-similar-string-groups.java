class Solution {
    public int numSimilarGroups(String[] strs) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++){
            parent.put(strs[i], strs[i]);
            rank.put(strs[i], 0);
        }
        
        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j < strs.length; j++){
                if(i != j){
                    if(isSimilar(strs[i], strs[j])){
                        unionHelper(strs[i], strs[j]);
                    }
                }
            }
        }
        
        int count = 0;
        
        for(String s : parent.keySet()){
            if(s.equals(parent.get(s))){
                count++;
            }
        }
        
        return count;
    }
    
    HashMap<String, String> parent;
    HashMap<String, Integer> rank;
    
    public boolean isSimilar(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if( s1.charAt(i) != s2.charAt(i)){
                count++;
            }
        }
        
        if(count <= 2){
            return true;
        } else {
            return false;
        }
        
    }
    
    public void unionHelper(String s1, String s2){
        String lead1 = find(s1);
        String lead2 = find(s2);
        
        if(!lead1.equals(lead2)){
            union(lead1, lead2);
        }
    }
    
     public void union(String a, String b){
        if(rank.get(a) < rank.get(b)){
            parent.put(a, b);
        } else if(rank.get(a) > rank.get(b)){
            parent.put(b, a);
        } else {
            parent.put(a, b);
            rank.put(b, rank.get(b) + 1);
        }
    }
    
    public String find(String x){
        if(parent.get(x).equals(x)){
            return x;
        } else {
            parent.put(x, find( parent.get(x) ) );
            return parent.get(x);
        }
    }
}