/* 
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

import java.util.*;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null){
            return result;
        }
		//采用队列存储当前元素
        Queue<TreeNode> layer=new LinkedList<TreeNode>();
		//ArrayList存储一行节点
        ArrayList<Integer> layerlist=new ArrayList<Integer>();
        layer.add(pRoot);
		//用end保存下一行节点个数
        int start=0,end=1;
        while(!layer.isEmpty()){
            TreeNode cur=layer.poll();
            layerlist.add(cur.val);
            start++;
            if(cur.left!=null){
                layer.offer(cur.left);
            }
            if(cur.right!=null){
                layer.offer(cur.right);
            }
			//如果已经取满一行节点
            if(start==end){
                result.add(layerlist);
                layerlist=new ArrayList<Integer>();
                end=layer.size();
                start=0;
            }
        }
        return result;
    }
    
}