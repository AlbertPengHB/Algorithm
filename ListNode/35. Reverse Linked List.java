

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

//时间复杂度超时
public class Solution {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode prev=head;
        ListNode curt=head.next;
        while(curt.next!=null){
            ListNode temp=curt.next;
            curt.next=prev;
            prev=curt;
            curt=temp;
        }
        curt.next=prev;
        return curt;
    }
}

//好的方法
public class Solution {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=head;
        ListNode curt=head.next;
        while(curt!=null){
            ListNode temp=curt.next;
            curt.next=prev;
            prev=curt;
            curt=temp;
        }
        head.next=null;  
        return prev;  
    }
}