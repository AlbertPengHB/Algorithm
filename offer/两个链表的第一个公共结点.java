/* 
输入两个链表，找出它们的第一个公共结点。
 */


/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
        int count1=0,count2=0;
        ListNode cur1=pHead1;
        ListNode cur2=pHead2;
        while(cur1!=null){
            count1++;
            cur1=cur1.next;
        }
        while(cur2!=null){
            count2++;
            cur2=cur2.next;
        }
        if(count1>=count2){
            return getCommon(pHead1,pHead2,count1-count2);
        }
        return getCommon(pHead2,pHead1,count2-count1);
    }
    
    private ListNode getCommon(ListNode longNode,ListNode shortNode,int dis){
        for(int i=1;i<=dis;i++){
            longNode=longNode.next;
        }
        while(longNode!=shortNode){
            longNode=longNode.next;
            shortNode=shortNode.next;
        }
        return longNode;
    }
    
    
    
}