class Solution {
    
    class Edge implements Comparable<Edge> {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
      
      public int compareTo(Edge o){
          return this.wt - o.wt;
      }
   }
    
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        
        int mstWeight = kruskals(n, edges, null, null);
        
        List<Integer> critical = new ArrayList<>();
        List<Integer> pcritical = new ArrayList<>();
        
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            
            int mstWeightAfterExluding = kruskals(n, edges, null, edge);
            
            if(mstWeightAfterExluding > mstWeight){
                critical.add(i);
            } else {
                int mstWeightAfterIncluding = kruskals(n, edges, edge, null);
                
                if(mstWeightAfterIncluding == mstWeight){
                    pcritical.add(i);
                }
                
            }
            
        }
        
        List<List<Integer>> res = new ArrayList<>();
        res.add(critical);
        res.add(pcritical);
        
        return res;
    }
    
    public int kruskals(int n, int[][] edges, int[] edgeToInclude, int[] edgeToExclude){
        parent = new int[n];
        rank = new int[n];
        
        comps = n;
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        int mstWeight = 0;
        
        for(int[] edge : edges){
            if(edge == edgeToExclude || edge == edgeToInclude){
                continue;
            }
            
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            pq.add(new Edge(u, v, w));
        }
        
        if(edgeToInclude != null){
            int a = find(edgeToInclude[0]);
            int b = find(edgeToInclude[1]);
            union(a, b);
            mstWeight += edgeToInclude[2];
        }
        
        while(pq.size() > 0){
            Edge top = pq.remove();
            
            int a = find(top.src);
            int b = find(top.nbr);
            
            if(a != b){
                union(a, b);
                mstWeight += top.wt;
            }
        }
     
        if(comps == 1){
            return mstWeight;
        } else {
            return Integer.MAX_VALUE;
        }
    }
    
    int[] parent;
    int[] rank;
    int comps;
   
   public void union(int s1l, int s2l){ 
       
       if(rank[s1l] < rank[s2l]){
           parent[s1l] = s2l;
       } else if(rank[s1l] > rank[s2l]){
           parent[s2l] = s1l;
       } else {
            parent[s1l] = s2l;
            rank[s2l]++;
       }
       
       comps--;
   }
   
   public int find(int x){
       if(parent[x] == x){
           return x;
       } else {
           int par = find(parent[x]);
           parent[x] = par;
           return par;
       }
   }
}