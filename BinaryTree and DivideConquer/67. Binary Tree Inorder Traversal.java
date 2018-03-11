//Given a binary tree, return the inorder traversal of its nodes' values.
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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result=new ArrayList<Integer>();
        Traverse(root,result);
        return result;
    }
    public void Traverse(TreeNode root,ArrayList<Integer> result){
        if(root==null){
            return;
        }
        Traverse(root.left,result);
        result.add(root.val);
        Traverse(root.right,result);
        
    }
}