/* 
输入一个链表，输出该链表中倒数第k个结点。
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
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null){
            return null;
        }
        int count=0;
        ListNode fast=head;
        ListNode slow=head;
        while(head!=null){
            count++;
            head=head.next;
        }
        if(count<k){
            return null;
        }
        for(int i=1;i<=k;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
        

    }
}