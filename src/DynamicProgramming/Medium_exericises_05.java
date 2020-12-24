package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 91、解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 题目数据保证答案肯定是一个 32 位的整数。
 */
public class Medium_exericises_05 {

    /**
     * 1、确定base case      当元素为1时，最小值为arr[0][0]
     * 2、确定变量:往base case中靠近的量   高度在变
     * 3、确定选择：什么导致了变量在动态变化  索引的变化
     * 4、梳理出状态转移方程    f(n) = f(n-1)+min(i,i+1)
     *
     * @param args
     */


    public static void main(String[] args) {
        String s = "10";
        System.out.println(new Medium_exericises_05().numDecodings(s));
    }

    /**
     * 分两种情况
     * 1、当前字符不与前字符联合 noJoin[i] = noJoin[i-1]+ join[i-1]
     * 2、当前字符与前字符联合   join[i] = noJoin[i-1]
     * 例外：当array[i] = 0  ，noJoin[i] = 0 ;
     *      当array[i-1]*10+array[i] >26时， join[i] =0 ;
     *
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] array = s.toCharArray() ;
        int len = s.length();
        int[] join = new int[len] ;
        int[] noJoin = new int[len] ;
         join[0] = 0 ;
         if(Integer.valueOf(""+array[0]) != 0 ){
             noJoin[0] = 1  ;
         }else {
             noJoin[0] = 0 ;
         }
         for (int i= 1;i<len;i++){
             if(Integer.valueOf(""+array[i]) == 0) {
                 noJoin[i] =0 ;
             }else {
                 noJoin[i] = noJoin[i-1]+join[i-1] ;
             }
             if(Integer.valueOf(""+array[i-1])*10+Integer.valueOf(""+array[i] )>26 ){
                 join[i] = 0 ;
             }else {
                 join[i] = noJoin[i-1] ;
             }
         }
         return noJoin[len-1]+join[len-1] ;
    }
}
