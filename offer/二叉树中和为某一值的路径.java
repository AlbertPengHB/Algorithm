/* 
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */


import java.util.ArrayList;
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

//Solution1递归思路
public class Solution {
    private ArrayList<ArrayList<Integer>> pathList=new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> path=new ArrayList<Integer>();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null){
            return pathList;
        }
        path.add(root.val);
        target=target-root.val;
        if(target==0&&root.left==null&&root.right==null){
            pathList.add(new ArrayList<Integer>(path));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
		//remove操作是移除最后一个元素，深度遍历完一条路径后要回退
        path.remove(path.size()-1);
        return pathList;
    }
}

//Solution2多函数递归方式
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> pathList=new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return pathList;
        }
        ArrayList<Integer> path=new ArrayList<Integer>();
        int sum=0;
        FindPath(root,target,pathList,path,sum);
        return pathList;
    }
    
    private void FindPath(TreeNode root,int target,ArrayList<ArrayList<Integer>> pathList,ArrayList<Integer> path,int sum){
        if(root==null){
            return;
        }
        sum=sum+root.val;
        if(root.left==null&&root.right==null){
            if(sum==target){
                path.add(root.val);
                pathList.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        path.add(root.val);
        FindPath(root.left,target,pathList,path,sum);
        FindPath(root.right,target,pathList,path,sum);
        path.remove(path.size()-1);
    }
}
