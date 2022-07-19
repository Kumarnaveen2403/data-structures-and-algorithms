class Solution {
    //it uses modified bellmen-ford to calculate minimum distance in terms of edge weight
    //using two arrays ensures that vertices are only discovered in k stops
    //by vising k + 1 edges
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] dis = new int[n];
        
        for(int i = 0; i < dis.length; i++){
            if(i == src){
                dis[i] = 0;
            } else {
                dis[i] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0; i < k + 1; i++){
            int[] temp = new int[n];
            
            for(int j = 0; j < dis.length; j++){
                temp[j] = dis[j];
            }
            
            for(int[] flight : flights){
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                
                if(temp[from] != Integer.MAX_VALUE){
                    dis[to] = Math.min(price + temp[from], dis[to]);
                }
            }
        }
        
        if(dis[dst] != Integer.MAX_VALUE){
            return dis[dst];
        } else {
            return -1;
        }
    }
}