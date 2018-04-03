/* 
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 
针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(num==null||num.length<=0||size<=0||num.length<size){
            return result;
        }
		//采用一个双向队列用于存储当前数组位置的下标
        LinkedList<Integer> indexDeque=new LinkedList<Integer>();
		//选择第一个滑动窗口中的最大值
		//当前位置的下标在size以内的话，则选出最大的值的下标存入双向队列中
        for(int i=0;i<size-1;i++){
            while(!indexDeque.isEmpty()&&num[i]>num[indexDeque.getLast()]){
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }
        
		//不断向后移动的过程
        for(int i=size-1;i<num.length;i++){
			//寻找当前加入元素后的最大下标
            while(!indexDeque.isEmpty()&&num[i]>num[indexDeque.getLast()]){
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
			//如果当前下标-双向队列中第一个最大下标+1>滑动窗口，则滑动窗口出队列
            if(i-indexDeque.getFirst()+1>size){
                indexDeque.removeFirst();
            }
            result.add(num[indexDeque.getFirst()]);
        }
        return result;
    }
}