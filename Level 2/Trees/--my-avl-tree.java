import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        int ht = 1;
        int bal = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode construct(int[] arr) {
        TreeNode root =  constructHelper(arr, 0, arr.length -1);
        return root;
    }
    
    private static TreeNode constructHelper(int[] arr, int lo, int hi){
        if(lo > hi){
            return null;
        }
        
        int mid = (lo + hi) / 2;
        
        TreeNode node = new TreeNode(arr[mid]);
        
        node.left = constructHelper(arr, lo, mid - 1);
        node.right = constructHelper(arr, mid + 1, hi);
        
        node.ht = Math.max(node.left != null ? node.left.ht : 0, node.right != null ? node.right.ht : 0) + 1;
        node.bal = (node.left != null ? node.left.ht : 0) - (node.right != null ? node.right.ht : 0);
        
        return node;
    }

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " [" + node.ht + ", " + node.bal + "] " + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }
    
    public static TreeNode add(TreeNode root, int val){
        if(root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }
        
        if(val < root.val){
            root.left = add(root.left, val);
        } else if(val > root.val){
            root.right = add(root.right, val);
        }
        
        node.ht = Math.max(node.left != null ? node.left.ht : 0, node.right != null ? node.right.ht : 0) + 1;
        node.bal = (node.left != null ? node.left.ht : 0) - (node.right != null ? node.right.ht : 0);
        
         return root;
    }
    
    public static TreeNode rotateRight(TreeNode root){
        
    }
    
    public static TreeNode rotateLeft(TreeNode root){
        
    }
    
    
    public static void main(String[] args) {
        int[] arr = {10, 12, 20, 25, 30, 37, 40, 50, 60, 62, 70, 75, 80, 87, 90};
        // int[] arr = {10, 12, 20, 25, 30, 37, 40, 50, 60, 62};
         
        TreeNode root = construct(arr);
        add(root, 5);
        display(root);
    }
}