/* 
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */

//采用上三角和下三角的方式进行计算，两个方块相乘即为最终的结果
/* 
B[0] = 1 * A[1] * A[2] * A[3] * A[4] *....*A[n-1] ;（没有A[0]）
B[1 ]= A[0] * 1 * A[2] * A[3] * A[4] *....*A[n-1] ;（没有A[1]）
B[2] = A[0] * A[1] * 1 * A[3] * A[4] *....*A[n-1] ;（没有A[2]）
 */
import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int[] B=new int[A.length];
        if(A==null||A.length<=0){
            return B;
        }
        int length=A.length;
        //计算上三角的结果
		B[0]=1;
        for(int i=1;i<length;i++){
            B[i]=B[i-1]*A[i-1];
        }
		//计算下三角的结果
        int temp=1;
        for(int j=length-2;j>=0;j--){
            temp=temp*A[j+1];
            B[j]=B[j]*temp;
        }
        return B;
    }
}