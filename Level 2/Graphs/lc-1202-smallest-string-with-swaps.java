class Solution {
    //using dsu, perform union on all the indexes that can be swaped
    //Or come under the same set
    //make priority queues for every set
    //add the characters in each priority queue from respective sets
    //remove the characters from sets and put in the right order
    int[] parent;
    int[] rank;
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent = new int[s.length()];
        rank = new int[s.length()];
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        for(List<Integer> list : pairs){
            int n1 = list.get(0);
            int n2 = list.get(1);
            
            int lead1 = find(n1);
            int lead2 = find(n2);
            
            if(lead1 != lead2){
                union(lead1, lead2);
            }
        }
        
        
        PriorityQueue<Character>[] pq = new PriorityQueue[s.length()];
        for(int i = 0; i < parent.length; i++){
            pq[i] = new PriorityQueue<>();
        }
        
         for(int i = 0; i < s.length(); i++){
            int lead = find(i);
            char ch = s.charAt(i);
            pq[lead].add(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            int lead = find(i);
            char ch = pq[lead].remove();
            sb.append(ch);
        }
        
        return sb.toString();
    }
    
    public void union(int a, int b){
        if(rank[a] < rank[b]){
            parent[a] = b;
        } else if(rank[b] < rank[a]){
            parent[b] = a;
        } else {
            parent[b] = a;
            rank[a]++;
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