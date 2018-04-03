/* 
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */


//Solution1：采用Java自动转换异常处理的方式  好！！！！
public class Solution {
    public boolean isNumeric(char[] str) {
        try{
            double re=Double.parseDouble(new String(str)); 
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
}

//Solution2：采用正则表达式进行匹配
public class Solution {
    public boolean isNumeric(char[] str) {
        String strString=new String(str);
        return strString.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }
}


//Solution3：剑指offer解法
public class Solution {
    private int index=0;
    public boolean isNumeric(char[] str) {
        if(str==null||str.length<=0){
            return false;
        }
        boolean flag=scanInteger(str);
        //当存在小数点的时候，进行无符号整数扫描
		if(index<str.length&&str[index]=='.'){
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }
        if(index<str.length&&(str[index]=='E'||str[index]=='e')){
            index++;
            flag=flag&&scanInteger(str);
        }
        return flag && index == str.length;
    }
    
    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-') ){
            index++;
        }
        return scanUnsignedInteger(str);
         
    }
     
    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9'){
            index++;
        }
        return start < index; //是否存在整数
    }
}