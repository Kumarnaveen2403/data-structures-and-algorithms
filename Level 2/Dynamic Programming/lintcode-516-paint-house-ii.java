public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }

        int[] colors = new int[costs[0].length];
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;

        for(int i = 0; i < colors.length; i++){
            int cost = costs[0][i];
            colors[i] = cost;

            if(cost < min){
                smin = min;
                min = cost;
            } else if(cost < smin){
                smin = cost;
            }
        }

        for(int i = 1; i < costs.length; i++){

            int nmin = Integer.MAX_VALUE;
            int nsmin = Integer.MAX_VALUE;

            for(int j = 0; j < costs[0].length; j++){

                if(colors[j] != min){
                    colors[j] = min + costs[i][j];
                } else {
                    colors[j] = smin + costs[i][j];
                }

                if(colors[j] < nmin){
                    nsmin = nmin;
                    nmin = colors[j];
                } else if(colors[j] < nsmin){
                    nsmin = colors[j];
                }
            }
            
            min = nmin;
            smin = nsmin;
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < colors.length; i++){
            ans = Math.min(ans, colors[i]);
        }

        return ans;
    }
}