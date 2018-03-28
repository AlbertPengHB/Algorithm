/* 
输入一个链表，从尾到头打印链表每个节点的值。
 */

/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(listNode==null) {
            return result;
        }
        ListNode curNode=listNode.next;
        listNode.next=null;
        while(curNode!=null){
            ListNode temp=curNode.next;
            curNode.next=listNode;
            listNode=curNode;
            curNode=temp;
        }
        while(listNode!=null){
            result.add(listNode.val);
            listNode=listNode.next;
        }
        return result;
    }
}

//solution2 Stack
import java.util.Stack;
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack=new Stack<>();
        while(listNode!=null){
            stack.push(listNode);
            listNode=listNode.next;
        }
        ArrayList<Integer> result=new ArrayList<Integer>();
        while(!stack.isEmpty()) {
            ListNode cur=stack.pop();
            result.add(cur.val);
        }
        return result;
    }
}