/* 
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */


import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       if(matrix==null||matrix[0]==null||matrix.length<=0||matrix[0].length<=0){
           return null;
       }
       int row=matrix.length;
       int col=matrix[0].length;
       ArrayList<Integer> result=new ArrayList<Integer>();
       //层数
       int layers=(Math.min(row,col)-1)/2+1;
       for(int i=0;i<layers;i++){
           //左至右
           for(int k=i;k<col-i;k++){
               result.add(matrix[i][k]);
           }
           //右上至右下
           for(int j=i+1;j<row-i;j++){
               result.add(matrix[j][col-i-1]);
           }
           //右至左
           for(int k=col-i-2;(k>=i)&&(row-i-1)!=i;k--){
               result.add(matrix[row-i-1][k]);
           }
           //左下至左上
           for(int j=row-i-2;(j>i)&&(col-i-1!=i);j--){
               result.add(matrix[j][i]);
           }
       }
       return result;
    }
}