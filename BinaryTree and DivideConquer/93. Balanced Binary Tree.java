//给定一个二叉树,确定它是高度平衡的。对于这个问题,一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1。

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

 
//Solution1（不好，有重复遍历） 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
     
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root==null){
            return 0;
        }
        int nLeft=maxDepth(root.left);
        int nRight=maxDepth(root.right);
        return (nLeft>nRight)?(nLeft+1):(nRight+1);
    }
    
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root==null){
            return true;
        }
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
}

//Solution2
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
     public boolean isBalanced(TreeNode root){
         return maxDepth(root)!=-1;
     }
     public int maxDepth(TreeNode root){
         if(root==null){
             return 0;
         }
         int left=maxDepth(root.left);
         int right=maxDepth(root.right);
         if(left==-1||right==-1||Math.abs(left-right)>1){
             return -1;
         }
         return Math.max(left,right)+1;
     }
}