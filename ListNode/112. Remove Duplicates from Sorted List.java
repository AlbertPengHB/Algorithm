
/* 
给定一个排序链表，删除所有重复的元素每个元素只留下一个。
样例：
给出 1->1->2->null，返回 1->2->null
给出 1->1->2->3->3->null，返回 1->2->3->null
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

//时间复杂度过高，不好
public class Solution {
    /**
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head==null){
            return null;
        }
        ListNode first=head;
        ListNode second=head.next;
        while(first!=null){
            if(first.val==second.val){
                int val=first.val;
                while(second!=null&&second.val==second.next.val){
                    second=second.next;
                }
                first.next=second.next;
            }
            else{
                first=second;
                second=second.next;
            }
        }
        return head;
    }
}


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
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head==null){
            return null;
        }
        
        ListNode temp=head;
        while(temp!=null){
            int val=temp.val;
            if((temp.next!=null)&&(temp.next.val==val)){
                temp.next=temp.next.next;
            }
            else{
                temp=temp.next;
            }
        }
        
        return head;
    }
}
