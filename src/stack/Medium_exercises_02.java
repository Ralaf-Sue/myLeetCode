package stack;

import java.util.*;

/**
 * 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class Medium_exercises_02 {
    public static void main(String[] args) {
        String sourceStr = "cbacdcbc";
        System.out.println(new Medium_exercises_02().removeDuplicateLetters(sourceStr));

    }

    /**
     * 官方思路：
     * 数据不存在，将数据压入栈中，并将以后还会出现，且比当前数据大的数据移除
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        if (null == s) return null;
        Deque<Character> letters = new ArrayDeque<>();
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++)  map.put(s.charAt(i),i);
        for(int i =0 ;i<s.length();i++){
            char ch = s.charAt(i) ;
            if(!letters.contains(ch)){
                while(!letters.isEmpty() && letters.peek() >= ch && map.get(letters.peek())> i){
                    letters.pop() ;
                }
                letters.push(ch);
            }
        }
        Iterator<Character> iterator = letters.descendingIterator();
        StringBuilder sb = new StringBuilder() ;
        while(iterator.hasNext()){
            sb.append(iterator.next()) ;

        }
        return sb.toString() ;
    }

}
