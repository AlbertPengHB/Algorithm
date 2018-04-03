/* 
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
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
//采用两个栈，分别实现奇数行节点和偶数行节点的存储
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null){
            return result;
        }
        ArrayList<Integer> layerlist;
        Stack<TreeNode> s1=new Stack<TreeNode>();
        Stack<TreeNode> s2=new Stack<TreeNode>();
        s1.push(pRoot);
		//如果两个站都不为空时，执行循环
        while(!s1.isEmpty()||!s2.isEmpty()){
            //如果奇数层栈不为空
			if(!s1.isEmpty()){
                layerlist=new ArrayList<Integer>();
                while(!s1.isEmpty()){
                    TreeNode cur=s1.pop();
					//将节点从左至右存入偶数层栈中
                    layerlist.add(cur.val);
                    if(cur.left!=null){
                        s2.push(cur.left);
                    }
                    if(cur.right!=null){
                        s2.push(cur.right);
                    }
                }
                result.add(layerlist);
            }
			//如果偶数层栈不为空
            else{
                layerlist=new ArrayList<Integer>();
                while(!s2.isEmpty()){
                    TreeNode cur=s2.pop();
                    layerlist.add(cur.val);
					//将节点从右至左存入奇数层栈中
                    if(cur.right!=null){
                        s1.push(cur.right);
                    }
                    if(cur.left!=null){
                        s1.push(cur.left);
                    }
                }
                result.add(layerlist);
            }
        }
        return result;
    }

}