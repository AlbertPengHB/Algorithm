/* 
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 
即输出P%1000000007
 */


public class Solution {
    public int InversePairs(int [] array) {
        if(array==null||array.length<=0){
            return 0;
        }
        int[] copy=new int[array.length];
        for(int i=0;i<array.length;i++){
            copy[i]=array[i];
        }
        int count=InversePairs(array,copy,0,array.length-1);
        return count;
    }
    
	//利用归并排序的思路，先将每个子数组进行排序，如果前一子数组中的数，大于后一子数组中的数，则其到后一数组的所有位置都构成逆序对
    private int InversePairs(int[] array,int[] copy,int low,int high){
        if(low==high){
            return 0;
        }
        int mid=low+(high-low)/2;
        int i=mid;
        int j=high;
        int locopy=high;
        int count=0;
		//此时传入参数copy和array改变位置，保证每次copy从array获得的结果都是最新排序好的数组
        int leftcount=InversePairs(copy,array,low,mid)%1000000007;
        int rightcount=InversePairs(copy,array,mid+1,high)%1000000007;
		//此时传入的参数也可以改为如下，即array和copy不调换顺序
		/* 
		int leftcount=InversePairs(array,copy,low,mid)%1000000007;
        int rightcount=InversePairs(array,copy,mid+1,high)%1000000007;
		此时则应该在return之前把copy计算出的值，返回给array
		*/
        while(i>=low&&j>mid){
            if(array[i]>array[j]){
                count=count+j-mid;
                copy[locopy]=array[i];
                locopy--;
                i--;
                if(count>=1000000007){
                    count=count%1000000007;
                }
            }
            else{
                copy[locopy]=array[j];
                locopy--;
                j--;
            }
        }
        while(i>=low){
            copy[locopy]=array[i];
            locopy--;
            i--;
        }
        while(j>mid){
            copy[locopy]=array[j];
            locopy--;
            j--;
        }
       /* 
		for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
	   */
        return (leftcount+rightcount+count)%1000000007;
    }
}