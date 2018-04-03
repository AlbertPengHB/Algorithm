/* 
请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */

//采用LinkedHashSet可有序地输出集合中第一个元素
import java.util.*;
public class Solution {
    //Insert one char from stringstream
    LinkedHashSet<Character> map=new LinkedHashSet<Character>();
	//当来字符时，判定集合中是否含有字符，如果有则删除该字符，否则添加新字符
    public void Insert(char ch)
    {
        if(map.contains(ch)){
            map.remove(ch);
        }
        else{
            map.add(ch);
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
		//采用迭代器获取当前集合中第一个元素
        Iterator it=map.iterator();
        if(it.hasNext()){
            return (char)it.next();
        }
        return '#';
    }
}