package stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Simple_exercises_02 {
    public static void main(String[] args) {
     Simple_exercises_02 day1= new Simple_exercises_02();
     String s =   "((" ;
        System.out.println(day1.isValid(s));

    }

    /**
     * 解1：使用了栈
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s==null || s.length()%2== 1) return false ;
        s = s.replace(" ","") ;
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (' ' == ch) {
                continue;
            }
            if (matchLeft(ch)) {
                characters.push(ch);
                continue;
            } else {
                if(!characters.isEmpty()){
                    Character leftChar = characters.pop();
                    if (ch == left2Right(leftChar)) {
                        continue;
                    }else {
                        return false ;
                    }

                }
                return false ;

            }

        }
       if(characters.empty()){
            return true ;
       }else {
            return false ;
       }

    }


    public boolean matchLeft(char i) {
        switch (i) {
            case '(':
                return true;
            case '[':
                return true;
            case '{':
                return true;
        }
        return false;
    }

    public char left2Right(char i) {
        switch (i) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
        }
        return ' ';
    }
    /**
     * 网上题解：
     * 成对的将() [] {} 替换为 '' ,最后判断是否为 ''
     */
}
