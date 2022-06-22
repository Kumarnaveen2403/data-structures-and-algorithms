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
    int i;
    public TreeNode recoverFromPreorder(String traversal) {
        
        i = 0;
        TreeNode node = treeFromString(traversal, 0);
        
        return node;
    }
    
    TreeNode treeFromString(String str, int depth) {
        int d = 0;
        
        while( (i + d) < str.length() && str.charAt(i + d) == '-'){
            d++;
        }
        
        int k = 0;
        while( (i + d + k) < str.length() && str.charAt(i + d + k) != '-'){
            k++;
        }
        
        if(d == depth){
            TreeNode node = new TreeNode();
            node.val = Integer.parseInt(str.substring(i + d, i + d + k));
            i = i + d + k;
            
            node.left = treeFromString(str, depth + 1);
            node.right = treeFromString(str, depth + 1);
            
            return node;
        }
        
        return null;
    }
}