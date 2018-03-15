/* 
给定一个链表，如果链表中存在环，则返回到链表中环的起始节点，如果没有环，返回null。
样例：给出 -21->10->4->5, tail connects to node index 1，返回10
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

//Solution1 超出时间，方法不好
public class Solution {
    /*
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        if(head==null||head.next==null){
            return null;
        }
        ListNode result=hasCycle(head);
        if(result!=null){
            while(result!=head){
                result=result.next;
                head=head.next;
            }
            return head;
        }
        else{
            return null;
        }
    }
    
    private ListNode hasCycle(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=slow){
            if(fast==null||fast.next==null){
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return fast;
    }
}

//Solution2减少一次重复，方法较好
public class Solution {
    /*
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        if(head==null||head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=slow){
            if(fast==null||fast.next==null){
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}

