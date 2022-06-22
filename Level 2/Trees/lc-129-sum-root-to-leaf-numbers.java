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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        helper(root, 0);
        
        return sum;
    }
    
    public void helper(TreeNode node, int nsf){
        if(node == null){
            return;
        }
        
        helper(node.left, nsf * 10 + node.val);
        helper(node.right, nsf * 10 + node.val);
        
        if(node.left == null && node.right == null){
            sum += nsf * 10 + node.val;
        }
        
    }
}