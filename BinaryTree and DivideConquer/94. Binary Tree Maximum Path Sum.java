//给出一棵二叉树，寻找一条路径使其路径和最大，路径可以在任一节点中开始和结束（路径和为两个节点之间所在路径上的节点权值之和）
//样例
/* 给出一棵二叉树：

       1
      / \
     2   3
 */
 
 
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
    private class ResultType {
        // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
        int singlePath, maxPath; 
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    private ResultType helper(TreeNode root){
        if(root==null){
           return new ResultType(0,Integer.MIN_VALUE);
        }
		//Divide
        ResultType left=helper(root.left);
        ResultType right=helper(root.right);
        //Conquer
		//计算从root往下的最大值
		int singlePath=Math.max(left.singlePath,right.singlePath)+root.val;
        singlePath=Math.max(singlePath,0);
		//计算任意节点的最大值
        int maxPath=Math.max(left.maxPath,right.maxPath);
        maxPath=Math.max(maxPath,left.singlePath+right.singlePath+root.val);
        return new ResultType(singlePath,maxPath);
    }
    public int maxPathSum(TreeNode root) {
        // write your code here
        ResultType result=helper(root);
        return result.maxPath;
    }
}