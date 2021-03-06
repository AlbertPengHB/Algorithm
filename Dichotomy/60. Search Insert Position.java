/**
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。
 * 你可以假设在数组中无重复元素。
 * [1,3,5,6]，5 → 2
 * [1,3,5,6]，2 → 1
 * [1,3,5,6]， 7 → 4
 * [1,3,5,6]，0 → 0
 */

public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A==null||A.length==0){
            return 0;
        }
        int start=0;
        int end=A.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(A[mid]==target){
                return mid;
            }
            else if(A[mid]<target){
                start=mid; //此时不再对mid进行加1，减1操作
            }
            else{
                end=mid;
            }
        }
        
        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}