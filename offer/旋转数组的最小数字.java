/* 
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */


import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array==null|array.length<0){
            return 0;
        }
        int start=0;
        int end=array.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            //array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
            if(array[mid]>array[end]){
                start=mid+1;
            }
            //array类似[1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边还是右边,这时只好一个一个试
            else if(array[mid]==array[end]){
                end=end-1;
            }
            //array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左边。因为右边必然都是递增的。
            //待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
            else{
                end=mid;
            }
        }
        return array[start];
    }
}