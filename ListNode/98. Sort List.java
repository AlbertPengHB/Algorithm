/* 
在 O(n log n) 时间复杂度和常数级的空间复杂度下给链表排序。
样例：给出 1->3->2->null，给它排序变成 1->2->3->null.
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

//归并排序解决问题
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        if(head==null||head.next==null){
            return head;
        }
        //将节点进行切分
        ListNode middle=findMiddle(head);
        ListNode right=sortList(middle.next);
        middle.next=null;
        ListNode left=sortList(head);
        return Merge(left,right);
    }
    
    //寻找中间节点
    private ListNode findMiddle(ListNode head){
        ListNode fast=head.next;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //偶数节点时指向偏左节点
        return slow;
    }
    
    //进行归并排序
    private ListNode Merge(ListNode head1,ListNode head2){
        //需要一个Dummy节点
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        //如果其中一组排完所有节点
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        return dummy.next;
    }
    
}