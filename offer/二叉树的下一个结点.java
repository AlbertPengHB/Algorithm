/* 
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */



/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/

//分成两类情况进行考虑：1、如果该节点有右子树  2、如果该节点没有右子树
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null){
            return null;
        }
		
		//如果该节点有右子树，则下一个输出的是其右子树中的最左子节点
        if(pNode.right!=null){
            pNode=pNode.right;
            while(pNode.left!=null){
                pNode=pNode.left;
            }
            return pNode;
        }
		
		//如果该节点没有右子树，则下一个输出的是其父节点（如果其是该节点是左节点的话），或者是其父节点左子节点的节点的父节点（如果其是该节点是右节点的话）
        while(pNode.next!=null){
            if(pNode.next.left==pNode){
                return pNode.next;
            }
            pNode=pNode.next;
        }
        return null;
    }
}