/* 
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
（注意：这两个序列的长度是相等的）
 */


import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
      if(pushA==null||popA==null||pushA.length<=0||popA.length==0||pushA.length!=popA.length){
          return false;
      }
      Stack<Integer> temp=new Stack<Integer>();
	  //查找出栈元素的位置
      int popIndex=0;
      for(int i=0;i<pushA.length;i++){
          temp.push(pushA[i]);
		  //当栈中元素不为空且栈顶元素等于出栈元素的时候，出栈
          while(!temp.isEmpty()&&temp.peek()==popA[popIndex]){
              temp.pop();
              popIndex++;
          }
      }
	  //当栈为空时，符合条件，否则两序列不相符
      return temp.isEmpty();
    }
}