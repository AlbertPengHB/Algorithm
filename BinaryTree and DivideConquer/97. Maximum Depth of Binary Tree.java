//Given a binary tree, find its maximum depth.
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

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

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
	 //递归解决
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root==null){
            return 0;
        }
        int nLeft=maxDepth(root.left);
        int nRight=maxDepth(root.right);
        return (nLeft>nRight)?(nLeft+1):(nRight+1);
    }
}