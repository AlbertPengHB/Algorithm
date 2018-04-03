/* 
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */


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

//采用递归的思路
public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        //先生成一个基于自身的镜像树
		return isSymmetrical(pRoot,pRoot);
    }
    
    boolean isSymmetrical(TreeNode pRoot1,TreeNode pRoot2){
        //如果两个节点同时为空则返回true
		if(pRoot1==null&&pRoot2==null){
            return true;
        }
		//如果两个节点不同时为空则返回false
        if(pRoot1==null||pRoot2==null){
            return false;
        }
		//如果两个节点的值不相同则返回false
        if(pRoot1.val!=pRoot2.val){
            return false;
        }
		//返回左镜像树的左节点和右镜像树的右节点，以及左镜像树的右节点和右镜像树的左节点的比较结果
        return isSymmetrical(pRoot1.left,pRoot2.right)&&isSymmetrical(pRoot1.right,pRoot2.left);
    }
}