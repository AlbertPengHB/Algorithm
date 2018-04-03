


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

//Solution1采用ArrayList存储中序遍历的结果，返回第k-1个即为所求节点
import java.util.*;
public class Solution {
    private ArrayList<TreeNode> result=new ArrayList<TreeNode>();
    TreeNode KthNode(TreeNode pRoot, int k)
    {
		//考虑k<=0的情况
        if(pRoot==null||k<=0){
            return null;
        }
        InOrderReversal(pRoot);
        if(result.size()<k){
            return null;
        }
        return result.get(k-1);
    }
    public void InOrderReversal(TreeNode pRoot){
        if(pRoot==null){
            return;
        }
        InOrderReversal(pRoot.left);
        result.add(pRoot);
        InOrderReversal(pRoot.right);
    }
}

//Solution2不用遍历所有节点，只要到k就停止遍历
import java.util.*;
public class Solution {
    private ArrayList<TreeNode> result=new ArrayList<TreeNode>();
    private TreeNode resultNode;
        
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null||k<=0){
            return null;
        }
        InOrderKthNode(pRoot,k);
        return resultNode;
    }
    public void InOrderKthNode(TreeNode pRoot,int k){
        if(pRoot==null){
            return;
        }
            InOrderKthNode(pRoot.left,k);
            result.add(pRoot);
			//当判定为k的时候就停止中序遍历
            if(result.size()==k){
                resultNode=result.get(k-1);
                return;
            }
            InOrderKthNode(pRoot.right,k);
    }
}