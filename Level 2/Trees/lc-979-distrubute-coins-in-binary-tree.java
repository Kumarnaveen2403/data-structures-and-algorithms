/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair{
    int nodes;
    int coins;
}

class Solution {
    int moves = 0;
    
    public int distributeCoins(TreeNode root) {
        
        helper(root);
        return moves;
    }
    
    public Pair helper(TreeNode node){
        if(node == null){
            return new Pair();
        }
        
        Pair lp = helper(node.left);
        Pair rp = helper(node.right);
        
        Pair pair = new Pair();
        pair.nodes = lp.nodes + rp.nodes + 1;
        pair.coins = lp.coins + rp.coins + node.val;
        
        moves += Math.abs(pair.nodes - pair.coins);
        
        return pair;
    }
}