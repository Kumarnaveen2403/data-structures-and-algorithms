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
    static int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxSumRec(root);
        
        return maxSum;
    }
    
    public int maxSumRec(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int ls = maxSumRec(root.left);
        int rs = maxSumRec(root.right);

        int ls_pos = Math.max(ls, 0);
        int rs_pos = Math.max(rs, 0);
        
        int max = ls_pos + rs_pos + root.val;
        
        if(max > maxSum){
            maxSum = max;
        }
        
        return (Math.max(ls_pos, rs_pos) + root.val);
    }
}