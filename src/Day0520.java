import java.util.*;

/**
 * @author SuZuQi
 * @title: Day0520
 * @projectName myLeetCode
 * @description: 1371题
 * @date 2020/5/20
 */
public class Day0520 {

    /**
     * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
     */

    public static void main(String[] args) {
        String test = "eleetminicoworoep";
        System.out.println(findTheLongestSubstring(test));

    }


    /**
     * 1、需要遍历每一个字符
     * 2、获取遍历时，字符串的存在元音的 数值，作为索引，并将字符串此时的key值存起来
     * 3、当遍历的时候再次获取同样的key值时，用当前索引-存入的数组的value值，此中差值字符串一定是 含元音的偶数字符串
     * 4、获取所有中最大的  元音偶数字符串即可
     * @param srcStr
     * @return
     */
    public static int  findTheLongestSubstring(String srcStr) {
        if (null == srcStr) return 0;
        Integer strLength = srcStr.length();
        int[] arr = new int[1<<5] ;
        Arrays.fill(arr,-1) ;
        int result = 0b00000;
        int max = 0 ;
        for (int i = 0; i < strLength; i++) {
            char ch = srcStr.charAt(i);
            if(ch == 'a') result ^= (1 << 0);
            if(ch == 'e') result ^= (1 << 1);
            if(ch == 'i') result ^= (1 << 2);
            if(ch == 'o') result ^= (1 << 3);
            if(ch == 'u') result ^= (1 << 4);

            //用数组的
            if(arr[result] < 0) {
                arr[result] = i   ;  //说明这个值尚未被记录，记录字符串的索引
            }else{
               max = Math.max(max,i   -arr[result])  ;  //说明这个字符串已经被记录了，比较最大值就行
            }
        }
         return max ;
    }

}
