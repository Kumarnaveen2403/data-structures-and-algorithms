class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        Arrays.fill(parent, -1);
        
        boolean twoParents = false;
        int[] e1 = null;
        int[] e2 = null;
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            if(parent[v] == -1){
                parent[v] = u;
            } else {
                twoParents = true;
                e2 = edge;
                e1 = new int[] {parent[v], v};
                break;
            }
        }
        
        dsu = new int[edges.length + 1];
        for(int i = 0; i < dsu.length; i++){
            dsu[i] = i;
        }
        
        if(!twoParents){
            //detect cycle
            int[] res = null;
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                
                int p1 = find(u);
                
                if(p1 == v){
                    res = edge;
                    break;
                } else {
                    dsu[v] = p1;
                }
            
            }
            
            return res;
        } else {
            //check if two parents case has cycle
            boolean noCycle = true;
            
             for(int[] edge : edges){
                if(edge == e2){
                    continue;
                }
                 
                int u = edge[0];
                int v = edge[1];
                
                int p1 = find(u);
                
                if(p1 == v){
                    noCycle = false;
                    break;
                } else {
                    dsu[v] = p1;
                }
            }
            
            if(noCycle){
                return e2;
            } else {
                return e1;
            }
            
        }
        
    }
    
    int[] dsu;
    
    int find(int x){
        if(dsu[x] == x){
            return x;
        } else {
            dsu[x] = find(dsu[x]);
            return dsu[x];
        }
    }
}