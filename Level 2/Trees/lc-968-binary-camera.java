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
    final int CAMERA = 1;
    final int MONITORED = 2;
    final int NOT_MONITORED = 3;
    int count = 0;
    
    public int minCameraCover(TreeNode root) {
        
        int status = getStatus(root);
        
        if(status == NOT_MONITORED){
            count++;
        }
        
        return count;
    }
    
    public int getStatus(TreeNode node){
        if(node == null){
            return MONITORED;
        }
        
        int ls = getStatus(node.left);
        int rs = getStatus(node.right);
        
        if(ls == NOT_MONITORED || rs == NOT_MONITORED){
            count++;
            return CAMERA;
        }
        
        if(ls == CAMERA || rs == CAMERA){
            return MONITORED;
        }
        
        if(ls == MONITORED && rs == MONITORED){
            return NOT_MONITORED;
        }
        
        return 0;
        
    }
}