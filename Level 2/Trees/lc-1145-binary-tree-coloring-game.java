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
    
    static int leftSize = 0;
    static int rightSize = 0;
    
    public int size(TreeNode node, int x){
        if(node == null){
            return 0;
        }
        
        int ls = size(node.left, x);
        int rs = size(node.right, x);
        
        if(node.val == x){
            leftSize = ls;
            rightSize = rs;
        }
        
        return ls + rs + 1;
        
    }
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        
        size(root, x);
        
        int maxTreeSize = Math.max(Math.max(leftSize, rightSize), n - leftSize - rightSize - 1);
        
        int restTreeSize = n - maxTreeSize;
        
        if(maxTreeSize > restTreeSize){
            return true;
        } else {
            return false;
        }
    }
}