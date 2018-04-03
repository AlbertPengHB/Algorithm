/* 
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */


/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=pHead;
        ListNode prev=dummy;
        while(pHead!=null){
			//首先判定pHead.next是否存在，如果不存在就不用进行后面的操作（应该将判定放在左边，否则会报错！！！！）
            if(pHead.next!=null&&pHead.val==pHead.next.val){
                int val=pHead.val;
				//首先判定pHead是否存在，如果不存在就不用进行后面的操作（应该将判定放在左边，否则会报错！！！！）
                while(pHead!=null&&pHead.val==val){
                    pHead=pHead.next;
                }
                prev.next=pHead;
            }
            else{
                prev=pHead;
                pHead=pHead.next;
            }
        }
        return dummy.next;
    }
}