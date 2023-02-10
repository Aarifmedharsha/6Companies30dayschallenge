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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] ret = robHelper(root);
        return Math.max(ret[0], ret[1]);
    }
    
    private int[] robHelper(TreeNode root) {
        int[] ret = new int[2];
        if (root == null) return ret;
        int[] lRet = robHelper(root.left);
        int[] rRet = robHelper(root.right);
        
        ret[0] = Math.max(lRet[0], lRet[1]) + Math.max(rRet[0], rRet[1]);
        ret[1] = lRet[0] + rRet[0] + root.val;
        return ret;
    }
}