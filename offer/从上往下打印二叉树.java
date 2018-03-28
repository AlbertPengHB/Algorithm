/* 
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */


import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

//采用一个队列辅助实现，每次队列元素出队时，将其左右子节点放入队列中
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> levelTraverse=new LinkedList<TreeNode>();
        levelTraverse.add(root);
        while(!levelTraverse.isEmpty()){
            TreeNode popNode=levelTraverse.poll();
            result.add(popNode.val);
            if(popNode.left!=null){
                levelTraverse.add(popNode.left);
            }
            if(popNode.right!=null){
                levelTraverse.add(popNode.right);
            }
        }
        return result;
    }
}