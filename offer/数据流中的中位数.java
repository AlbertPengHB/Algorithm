/* 
如何得到一个数据流中的中位数？
如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */


//Solution1：暴力破解法，每次都重复计算中间数
import java.util.*;
public class Solution {
    private ArrayList<Double> result=new ArrayList<Double>();
    public void Insert(int num) {
        result.add(Double.valueOf(num));
        Collections.sort(result);
    }

    public Double GetMedian() {
        if(result==null||result.size()<=0){
            return Double.MIN_VALUE;
        }
        int length=result.size()-1;
        double resultDouble;
        if(result.size()%2==0){
            resultDouble=(result.get(length/2)+result.get(length/2+1))/2;
        }
        else{
            resultDouble=result.get(length/2);
        }
        return resultDouble;
    }
}


//Solution2采用大根堆和小根堆分别存储左半边的数和右半边的数，直接取两个根堆的堆顶即可求出中位数
import java.util.*;
public class Solution {

    private int count=0;
	//PriorityQueue默认是小根堆，需要重写Comparator方法，生成大根堆
    private Queue<Integer> minHeap=new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public void Insert(Integer num) {
        if(count%2==0){
			//当数据总数为偶数时，新加入的元素，应当进入小根堆
			//（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
			//1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
            maxHeap.offer(num);
            int val=maxHeap.poll();
			//2.筛选后的【大根堆中的最大元素】进入小根堆
            minHeap.offer(val);
			//此时小根堆中的元素多一个
        }
        else{
			//当数据总数为奇数时，新加入的元素，应当进入大根堆
			//（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
			//1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            minHeap.offer(num);
            int val=minHeap.poll();
			//2.筛选后的【小根堆中的最小元素】进入大根堆
            maxHeap.offer(val);
			//此时两个根堆中元素一样多
        }
        count++;
    }

    public Double GetMedian() {
        if(count%2==0){
            return new Double((maxHeap.peek()+minHeap.peek()))/2;
        }
        return new Double(minHeap.peek());
    }


}