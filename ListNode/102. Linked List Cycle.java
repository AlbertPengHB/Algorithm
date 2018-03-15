/* 
给定一个链表，判断它是否有环。
样例:给出 -21->10->4->5, tail connects to node index 1，返回 true
 */


/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if(head==null||head.next==null){
            return false;
        }
		//fast应比slow提前一个点
        ListNode slow=head;
        ListNode fast=slow.next;
		//如果两个链表不想等就一直往下走
        while(fast!=slow){
            if(fast==null||fast.next==null){
                return false;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return true;
    }
}