package Traversal;
import java.util.Stack;        
    
public class TreeNode {    
    private char val;    
    private TreeNode left;    
    private TreeNode right;    
    
    public TreeNode(char val) {    
        this.val = val;    
    }    
    
    // 先序遍历递归     
    public static void preOrder(TreeNode root) {    
        if (root == null) {    
            return;    
        }    
        System.out.print(root.val);    
        preOrder(root.left);    
        preOrder(root.right);    
    }    
    
    // 中序遍历递归     
    public static void InOrder(TreeNode root) {    
        if (root == null) {    
            return;    
        }    
        InOrder(root.left);    
        System.out.print(root.val);    
        InOrder(root.right);    
    }    
    
    // 后序遍历递归     
    public static void PostOrder(TreeNode root) {    
        if (root == null) {    
            return;    
        }    
        PostOrder(root.left);    
        PostOrder(root.right);    
        System.out.print(root.val);    
    }    
    
    // 先序遍历非递归     
    public static void nonRecurPreOrder(TreeNode root) {    
    	if(root==null){ 
        	return;  
        }
    	Stack<TreeNode> stack = new Stack<TreeNode>();    
        while (root != null || !stack.empty()) {    
            while (root != null) {    
                System.out.print(root.val);    
                stack.push(root);    
                root = root.left;    
            }    
            if (!stack.empty()) {    
                root = stack.pop();    
                root = root.right;    
            }    
        }    
    }    
    
    // 中序遍历非递归     
    public static void nonRecurInOrder(TreeNode root) {    
    	if(root==null){ 
        	return;  
        }
    	Stack<TreeNode> stack = new Stack<TreeNode>();    
        while (root != null || !stack.empty()) {    
            while (root != null) {    
                stack.push(root);    
                root = root.left;    
            }    
            if (!stack.empty()) {    
                root = stack.pop();    
                System.out.print(root.val);    
                root = root.right;    
            }    
        }    
    }    
    
    // 后序遍历非递归     
    public static void nonRecurPostOrder(TreeNode root) {  
        if(root==null){ 
        	return;  
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        TreeNode current = null;  
        TreeNode pre = null;  
        stack.push(root);  
        while(!stack.isEmpty()) {  
            current = stack.peek();  
            if((current.left==null && current.right==null) || (pre!=null && (pre == current.left || pre == current.right))) {  
                System.out.print(current.val);  
                stack.pop();  
                pre = current;  
            }  
            else {  
                if(current.right!=null) {  
                    stack.push(current.right);  
                }  
                if(current.left != null) {  
                    stack.push(current.left);  
                }  
            }  
        }  
    }  
    
    
    public static void main(String[] args) {    
        TreeNode b1 = new TreeNode('a');    
        TreeNode b2 = new TreeNode('b');    
        TreeNode b3 = new TreeNode('c');    
        TreeNode b4 = new TreeNode('d');    
        TreeNode b5 = new TreeNode('e');    
    
        /**  
         *      a   
         *     / \  
         *    b   c  
         *   / \  
         *  d   e  
         */    
        b1.left = b2;    
        b1.right = b3;    
        b2.left = b4;    
        b2.right = b5;    
    
        System.out.print("先序遍历递归：  ");
        TreeNode.preOrder(b1);    
        System.out.println();
        
        System.out.print("先序遍历非递归：  ");
        TreeNode.nonRecurPreOrder(b1);    
        System.out.println();
        
        System.out.print("中序遍历递归：  ");
        TreeNode.InOrder(b1);    
        System.out.println();
        
        System.out.print("中序遍历非递归：  ");
        TreeNode.nonRecurInOrder(b1);    
        System.out.println(); 
        
        System.out.print("后序遍历递归：  ");
        TreeNode.PostOrder(b1);    
        System.out.println();
        
        System.out.print("后序遍历非递归：  ");
        TreeNode.nonRecurPostOrder(b1);    
    }    
}    