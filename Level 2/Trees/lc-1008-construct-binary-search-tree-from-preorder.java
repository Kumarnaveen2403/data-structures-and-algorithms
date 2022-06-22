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
    
    int index = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = helper(Integer.MIN_VALUE, Integer.MAX_VALUE, preorder);
        return root;
    }
    
    public TreeNode helper(int min, int max, int[] preorder){
        if(index == preorder.length){
            return null;
        }
        
        if(preorder[index] < min || preorder[index] > max){
            return null;
        }
        
        int val = preorder[index];
        TreeNode node = new TreeNode(val);
        index++;
        
        node.left = helper(min, val, preorder);
        node.right = helper(val, max, preorder);
        
        return node;
    }
}