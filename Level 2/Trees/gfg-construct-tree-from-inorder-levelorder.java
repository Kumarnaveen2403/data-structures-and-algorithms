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
    // TreeNode prev = null;
    class Pair {
        TreeNode head;
        TreeNode tail;
    }
    
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        
//         flatten(root.right);
//         flatten(root.left);
        
//         root.left = null;
//         root.right = prev;
//         prev = root;
        
        helper(root);
        
        // return root;
        
    }
    
    public Pair helper(TreeNode node) {
        // if(node == null){
        //     return new Pair();
        // }
        
        
        if(node.left != null && node.right != null) {
            
            Pair lp = helper(node.left);
            Pair rp = helper(node.right);
            
            lp.tail.right = rp.head;
            node.right = lp.head;
            node.left = null;

            Pair pair = new Pair();
            pair.head = node;
            pair.tail = rp.tail;

            return pair;
        } else if(node.right != null){
            Pair rp = helper(node.right);

            Pair pair = new Pair();
            pair.head = node;
            pair.tail = rp.tail;

            return pair;
        } else if(node.left != null){
            Pair lp = helper(node.left);
            
            node.right = lp.head;
            node.left = null;

            Pair pair = new Pair();
            pair.head = node;
            pair.tail = lp.tail;

            return pair; 
        } else {
            Pair pair = new Pair();
            pair.head = node;
            pair.tail = node;
            return pair;
        }
        
    }
}