public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }

        int r = costs[0][0];
        int b = costs[0][1];
        int g = costs[0][2];

        for(int i = 1; i < costs.length; i++){
            int nr = costs[i][0] + Math.min(b, g);
            int nb = costs[i][1] + Math.min(r, g);
            int ng = costs[i][2] + Math.min(r, b);

            r = nr;
            b = nb;
            g = ng;
        }

        return Math.min(r, Math.min(b, g));
    }
}
