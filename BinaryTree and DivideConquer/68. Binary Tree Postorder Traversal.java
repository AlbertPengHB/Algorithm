//Given a binary tree, return the postorder traversal of its nodes' values.
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
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        ArrayList<Integer> left=postorderTraversal(root.left);
        ArrayList<Integer> right=postorderTraversal(root.right);
        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        return result;
    }
}