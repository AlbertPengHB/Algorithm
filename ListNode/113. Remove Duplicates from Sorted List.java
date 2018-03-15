/* 
给定一个排序链表，删除所有重复的元素只留下原链表中没有重复的元素。
样例:
给出 1->2->3->3->4->4->5->null，返回 1->2->5->null
给出 1->1->1->2->3->null，返回 2->3->null
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
     * @param head: head is the head of the linked list
     * @return: head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        //prev vs curt
        ListNode prev=dummy;
        ListNode curt=head;
        while(curt!=null){
            if(curt.next!=null&&curt.val==curt.next.val){
                int val=curt.val;
                while(curt!=null&&curt.val==val){
                    curt=curt.next;
                }
                prev.next=curt;
            }
            else{
                prev=curt;
                curt=curt.next;
            }
        }
        return dummy.next;
        
    }
}