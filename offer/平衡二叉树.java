/* 
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */


public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        //返回的深度如果不为1的话，则其为平衡二叉树
		return MaxDepth(root)!=-1;
    }
    
    private int MaxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=MaxDepth(root.left);
        int right=MaxDepth(root.right);
        if(left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
}