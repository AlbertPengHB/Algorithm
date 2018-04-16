
public int countLoopNode(TreeNode head){
		if(head==null||head.next==null){
			return 0;
		}
		//为了寻找正确相遇点，应该二者都从头节点一起出发
		TreeNode slow=head.next;
		TreeNode fast=head.next.next;
		while(head!=null||head.next!=null){
			//判断链表是否有环
			if(fast.val==slow.val){
				//寻找环中入口节点
				fast=head;
				while(fast.val!=slow.val){
					fast=fast.next;
					slow=slow.next;
				}
				if(fast.val==slow.val){
					TreeNode loop=fast;
					//计算头节点到环中入口节点的节点数
					fast=head;
					int leftCount=1;
					while(fast.val!=slow.val){
						fast=fast.next;
						leftCount++;
					}
					//计算环中节点数
					fast=fast.next;
					int rightCount=1;
					while(fast.val!=slow.val){
						fast=fast.next;
						rightCount++;
					}
					return leftCount+rightCount-1;  //入口节点被计算了两次，所以需要减1
				}
			}		
			slow=slow.next;
			fast=fast.next.next;
		}
		return 0;
	}