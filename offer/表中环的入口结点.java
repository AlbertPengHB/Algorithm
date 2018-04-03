/* 

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

//Solution1：环前面的路程 = 数个环的长度（为可能为0） + 环的长度 - 环到相遇点的路程
/* 
可以让一个指针从起点A开始走，让一个指针从相遇点B开始继续往后走，
2个指针速度一样，那么，当从原点的指针走到环入口点的时候（此时刚好走了x）
从相遇点开始走的那个指针也一定刚好到达环入口点。
所以2者会相遇，且恰好相遇在环的入口点。
 */
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null||pHead.next==null||pHead.next.next==null){
            return null;
        }
		//先找到快慢指针相遇的节点
        ListNode fast=pHead.next.next;
        ListNode slow=pHead.next;
        while(fast!=slow){
            if(fast.next!=null&&fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            else{
                return null;
            }
        }
		//将一个指针赋为头节点，然后两个指针同时走，当再次相遇时为环的入口节点
        fast=pHead;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}

//Solution2：剑指offer思路
/* 
三步走：
1、判定是否有环
2、计算环中节点数
3、两个指针同时指向头节点，一个指针先走环中节点的步数，当两指针再次相遇即为环的入口地址
 */
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null||pHead.next==null||pHead.next.next==null){
            return null;
        }
		
		//判定是否有环
        ListNode fast=pHead.next.next;
        ListNode slow=pHead.next;
        while(fast!=slow){
            if(fast.next!=null&&fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            else{
                return null;
            }
        }
		
		//计算环中节点数
        int count=1;
        int key=fast.val;
        fast=fast.next;
        while(fast.val!=key){
            count++;
            fast=fast.next;
        }
		
		//一个指针先走count步
        fast=pHead;
        slow=pHead;
        while(count>0){
            count--;
            fast=fast.next;
        }
		//寻找环的入口节点
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}