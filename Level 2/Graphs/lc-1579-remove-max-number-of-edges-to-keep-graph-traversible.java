class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parentAlice = new int[n + 1];
        int[] rankAlice = new int[n + 1];
        
        int[] parentBob = new int[n + 1];
        int[] rankBob = new int[n + 1];
        
        for(int i = 0; i <= n; i++){
            parentAlice[i] = i;
            parentBob[i] = i;
        }
        
        int maxRemovable = 0;
        
        for(int[] edge : edges){
            if(edge[0] == 3){
                int leadAliceU = find(edge[1], parentAlice);
                int leadAliceV = find(edge[2], parentAlice);
                
                if(leadAliceU != leadAliceV){
                    union(leadAliceU, leadAliceV, parentAlice, rankAlice);
                }
                
                int leadBobU = find(edge[1], parentBob);
                int leadBobV = find(edge[2], parentBob);
                
                if(leadBobU != leadBobV){
                    union(leadBobU, leadBobV, parentBob, rankBob);
                } else {
                    maxRemovable++;
                }
        
            }
        }
        
        for(int[] edge : edges){
            if(edge[0] == 1){ //only traversed by Alice
                
                int leadAliceU = find(edge[1], parentAlice);
                int leadAliceV = find(edge[2], parentAlice);
                
                if(leadAliceU != leadAliceV){
                    union(leadAliceU, leadAliceV, parentAlice, rankAlice);
                } else {
                    maxRemovable++;
                }
                
            } else if(edge[0] == 2){ //only traversed by Bob
                   
                int leadBobU = find(edge[1], parentBob);
                int leadBobV = find(edge[2], parentBob);
                
                if(leadBobU != leadBobV){
                    union(leadBobU, leadBobV, parentBob, rankBob);
                } else {
                    maxRemovable++;
                }
                
            }
        }
        
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(parentAlice[i] == i){
                count++;
            }
            
            if(parentBob[i] == i){
                count++;
            }
        }
        
        if(count > 2){
            return -1;
        } else {
            return maxRemovable;
        }
        
    }
    
    public void union(int a, int b, int[] parent, int[] rank){
        if(rank[a] < rank[b]){
            parent[a] = b;
        } else if(rank[b] < rank[a]){
            parent[b] = a;
        } else {
            parent[a] = b;
            rank[b]++;
        }
    }
    
    public int find(int x, int[] parent){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x], parent);
            return parent[x];
        }
    }
}