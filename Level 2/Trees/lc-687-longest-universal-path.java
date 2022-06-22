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
    int maxLen = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        maxLen = 0;
        
        if(root == null){
            return 0;
        }
        
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
            
        if(left + right + 1 > maxLen){
            maxLen = left + right + 1;
        }
        
        return maxLen - 1;
    }
    
    public int helper(TreeNode node, int val){
        if(node == null){
            return 0;
        }
        
        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);
        
        if(left + right + 1 > maxLen){
            maxLen = left + right + 1;
        }
        
        if(val != node.val){
            return 0;
        } else {
            return Math.max(left, right) + 1;
        }
            
    }
}