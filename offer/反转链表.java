/* 
输入一个链表，反转链表后，输出链表的所有元素。
 */


/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode curNode=head.next;
        head.next=null;
        while(curNode!=null){
            ListNode temp=curNode.next;
            curNode.next=head;
            head=curNode;
            curNode=temp;
        }
        return head;
    }
}