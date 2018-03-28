/* 
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

//Solution1，采用哈希表进行实现
import java.util.*;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length<=0){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                int result=map.get(array[i])+1;
                map.put(array[i],result);
            }
            else{
                map.put(array[i],1);
            }
            if(map.get(array[i])>array.length/2){
                return array[i];
            }
        }
        return 0;
    }
}

//Solution2，采用类似栈的方法，需要遍历两遍
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length<=0){
            return 0;
        }
        int num=array[0];
        int count=1;
        for(int i=1;i<array.length;i++){
            if(count==0){
                num=array[i];
                count=1;
            }
            else{
                if(num==array[i]){
                    count++;
                }
                else{
                    count--;
                }
            }        
        }
        count=0;
		//重新计算一遍，看看当前选出的数是否大于数组长度的一半
        for(int i=0;i<array.length;i++){
           if(num==array[i]){
               count++;
           }
        }
        if(count*2<=array.length){
           num=0;
        }
       return num;
    }
}