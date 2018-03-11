/*LintCode28
 *写出一个高效的算法来搜索 m × n矩阵中的值。
 *这个矩阵具有以下特性：
 *每行中的整数从左到右是排序的。
 *每行的第一个数大于上一行的最后一个整数。
*/

/*
 *考虑下列矩阵：
 *[
 *  [1, 3, 5, 7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 *]
 *给出 target = 3，返回 true
*/

//此题可以用Binary Search Once或Binary Search Twice
public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix.length<=0||matrix[0].length<=0){
            return false;
        }
        int raw=matrix.length;
        int col=matrix[0].length;
        int start=0;
        int end=raw*col-1;
        while(start<=end){   //此时如果用start+1<end会出错
            int mid=start+(end-start)/2;
            int number=matrix[mid/col][mid%col];
            if(number==target){
                return true;
            }
            else if(number>target){
                end=mid-1;
            }
            else if(number<target){
                start=mid+1;
            }
        }
        return false;
    }
}