/* 
给定一个单链表L: L0→L1→…→Ln-1→Ln,
重新排列后为：L0→Ln→L1→Ln-1→L2→Ln-2→…
必须在不改变节点值的情况下进行原地操作。
样例：给出链表 1->2->3->4->null，重新排列后为1->4->2->3->null。
 */

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: nothing
     */
    public void reorderList(ListNode head) {
        // write your code here
        if(head==null||head.next==null){
            return;
        }
		//分成三个部分
		//1.查找中间节点  2.后半部分进行反转   3.看成两个链表进行合并
        ListNode middle=getMiddle(head);
        ListNode tail=Reverse(middle.next);
        middle.next=null;
        Merge(head,tail);
    }
    
    private ListNode getMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    
    private ListNode Reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
    
    private void Merge(ListNode head1,ListNode head2){
        ListNode dummy=new ListNode(0);
        int index=0;
        while(head1!=null&&head2!=null){
            if(index%2==0){
                dummy.next=head1;
                head1=head1.next;
            }
            else{
                dummy.next=head2;
                head2=head2.next;
            }
            dummy=dummy.next;
            index++;
        }
        if(head1!=null){
            dummy.next=head1;
        }
        if(head2!=null){
            dummy.next=head2;
        }
    }
}