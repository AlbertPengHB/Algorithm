/* 
输入n个整数，找出其中最小的K个数。
例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */


import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        if(input==null||input.length<=0||input.length<k){
            return result;
        }
        buildMaxHeap(input, k-1);
        for(int i=k;i<input.length;i++){
            if(input[i]<input[0]){
                swap(input,i,0);
                buildMaxHeap(input,k-1);
            }
        }
        for(int j=0;j<k;j++){
            result.add(input[j]);
        }
        return result;
    }
    
    private static void buildMaxHeap(int[] input, int lastIndex){
         //从lastIndex处节点（最后一个节点）的父节点开始 
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点 
            int k=i;
            //如果当前k节点的子节点存在  
            while(k*2+1<=lastIndex){
                //k节点的左子节点的索引 
                int biggerIndex=2*k+1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if(biggerIndex<lastIndex){  
                    //若果右子节点的值较大  
                    if(input[biggerIndex]<input[biggerIndex+1]){  
                        //biggerIndex总是记录较大子节点的索引  
                        biggerIndex++;  
                    }  
                }  
                //如果k节点的值小于其较大的子节点的值  
                if(input[k]<input[biggerIndex]){  
                    //交换他们  
                    swap(input,k,biggerIndex);  
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值  
                    k=biggerIndex;  
                }else{  
                    break;  
                }  
            }
        }
    }
    
    private static void swap(int[] input, int i, int j) {  
        int tmp=input[i];  
        input[i]=input[j];  
        input[j]=tmp;  
    } 
}