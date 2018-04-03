/* 
统计一个数字在排序数组中出现的次数。
 */


public class Solution {
    public int GetNumberOfK(int [] array , int k) {
       if(array==null||array.length<=0){
           return 0;
       }
	   //采用二分查找思路分别找到满足k的开始节点和最终节点
       int first=GetFirstNumberOfK(array,k,0,array.length-1);
       int last=GetLastNumberOfK(array,k,0,array.length-1);
       int number=0;
       if(first>-1&&last>-1){
           number=last-first+1;
       }
       return number;
    }
    
    private int GetFirstNumberOfK(int[] array,int k,int start,int end){
        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;
        if(array[mid]==k){
			//当mid>0时，如果前一个不是k，则mid就是k的第一个节点
            if((mid>0&&array[mid-1]!=k)||mid==0){
                return mid;
            }
            else{
                end=mid-1;
            }
        }
        else if(array[mid]<k){
            start=mid+1;
        }
        else{
            end=mid-1;
        }
        return GetFirstNumberOfK(array,k,start,end);
    }
    
    private int GetLastNumberOfK(int[] array,int k,int start,int end){
        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;
        if(array[mid]==k){
			//当mid<数组长度的时候，如果后一个不是k，则mid就是k的最后一个节点
            if((mid<array.length-1&&array[mid+1]!=k)||mid==array.length-1){
                return mid;
            }
            else{
                start=mid+1;
            }
        }
        else if(array[mid]<k){
            start=mid+1;
        }
        else{
            end=mid-1;
        }
        return GetLastNumberOfK(array,k,start,end);
    }
    
    
}