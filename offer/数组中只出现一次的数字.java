/* 
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */


//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.*;
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length<=0){
            return;
        }
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<Integer,Integer>();
        int touch1=0;
        int touch2=0;
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                int time=map.get(array[i]);
                map.put(array[i],++time);
            }
            else{
                map.put(array[i],1);
            }
        }
        for(int i=0;i<array.length;i++){
            if(map.get(array[i])==1){
                if(num1[0]!=array[i]&&touch1==0){
                    num1[0]=array[i];
                    touch1=1;
                }
                else if(touch1==1){
                    num2[0]=array[i];
                }
            }
        }
    }
}