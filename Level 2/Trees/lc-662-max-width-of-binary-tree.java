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
class Solution {
    class Pair {
        int min;
        int max;
    }
    
    int maxWidth;
    
    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        HashMap<Integer, Pair> map = new HashMap<>();
        helper(root, 1, 1, map);
        
        return maxWidth;
    }
    
    public void helper(TreeNode node, int level, int idx, HashMap<Integer, Pair> map){
        if(node == null){
            return;    
        }
        
        helper(node.left, level + 1, idx * 2, map);
        helper(node.right, level + 1, idx * 2 + 1, map);
        
        if(map.containsKey(level)){
            Pair p = map.get(level);
            p.max = idx;
            
            if(p.max - p.min + 1 > maxWidth){
                maxWidth = p.max - p.min + 1;
            }
        } else {
            Pair p = new Pair();
            p.min = idx;
            p.max = idx;
            
            maxWidth = maxWidth > 1 ? maxWidth : 1;
            
            map.put(level, p);
        }
        
    }
}