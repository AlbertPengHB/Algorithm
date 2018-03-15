/* 
给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。
你应该保留两部分内链表节点原有的相对顺序。
样例：
给定链表 1->4->3->2->5->2->null，并且 x=3
返回 1->2->2->4->3->5->null
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

//时间复杂度超时，不好
public class Solution {
    /**
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head==null){
            return null;
        }
        ListNode leftDummy=new ListNode(0);
        leftDummy.next=head;
        ListNode leftBegin=leftDummy;
        ListNode rightDummy=new ListNode(0);
        rightDummy.next=head;
        ListNode rightBegin=rightDummy;
        while(head!=null){
            if(head.val<x){
                leftDummy.val=head.val;
                leftDummy=leftDummy.next;
            }
            else{
                rightDummy.val=rightDummy.val;
                rightDummy=rightDummy.next;
            }
            head=head.next;
        }
        leftDummy.next=rightBegin.next;
        return leftBegin.next;
        
        
    }
}


//该方法时间复杂度较小
public class Solution {
    /**
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head==null){
            return null;
        }
		//只多占用了八个字节
        ListNode leftDummy=new ListNode(0);
        ListNode leftBegin=leftDummy;
        ListNode rightDummy=new ListNode(0);
        ListNode rightBegin=rightDummy;
        while(head!=null){
            if(head.val<x){
                leftBegin.next=head;
                leftBegin=head;
            }
            else{
                rightBegin.next=head;
                rightBegin=head;
            }
            head=head.next;
        }
        rightBegin.next=null;
        leftBegin.next=rightDummy.next;
        return leftDummy.next;
        
        
    }
}