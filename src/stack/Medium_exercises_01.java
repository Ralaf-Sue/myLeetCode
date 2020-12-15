package stack;

import java.util.*;

/**
 * 简化路径
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * <p>
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 */
public class Medium_exercises_01 {

    public static void main(String[] args) {
        String sourceStr = "/a//b////c/d//././/..";
        System.out.println(new Medium_exercises_01().simplifyPath1(sourceStr));
    }

    /**
     * 思路：1、分割  2、.. 弹栈  3 拼接栈
     * @param path
     * @return
     */
    private String simplifyPath1(String path) {
        if(null == path ) return null  ;
        String arr[] = path.split("/") ;
        Deque<String> deque = new ArrayDeque<>() ;
//        Arrays.asList(arr)
//                .forEach(str->{
//                    if(".".equals(str) || "".equals(str)){
//                        return ;
//                    }else if("..".equals(str)){
//                        if(!deque.isEmpty()) deque.pop() ;
//                    }else {
//                        deque.push(str);
//                    }
//                });
        for(String str :arr){
            if(".".equals(str) || "".equals(str)){
                continue ;
            }else if("..".equals(str)){
                if(!deque.isEmpty()) deque.pop() ;
            }else {
                deque.push(str);
            }
        }
        StringBuilder sb = new StringBuilder() ;
        Iterator<String> iterator = deque.descendingIterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            sb.append("/").append(next) ;
        }
        if(sb.length() == 0) sb.append("/") ;
        return sb.toString();

    }

    /** 
     * 第一步：使用正则去掉 "////"
     * 第二步：遍历string ，遇.去掉，遇..往上
     *
     * @param path
     * @return
     */
    @Deprecated //无法解决 "/...."的问题
    public String simplifyPath(String path) {

        if (null == path || path.length() == 0) return null;
        path = path.replaceAll("/+", "/");
        int length = path.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {

            char currentCh = path.charAt(i);
            if ('.' == currentCh) {
                if (i + 1 < length && '.' == path.charAt(i + 1)) {
                    int delEndIndex = sb.length() - 1;
                    sb = sb.deleteCharAt(delEndIndex);
                    if (!"".equals(sb.toString()))
                        sb = sb.delete(sb.lastIndexOf("/"), sb.length());
                    if ("".equals(sb.toString())) sb.append("/");
                    i++;
                } else {
                    if (!"/".equals(sb.toString()))
                        sb = sb.deleteCharAt(sb.length() - 1);

                }
            } else {
                sb.append(path.charAt(i));
            }

        }
        String result = sb.toString();
        if (result.endsWith("/") && result.length() != 1) result = result.substring(0, result.lastIndexOf("/"));
        result = result.replaceAll("/+", "/");

        return result;


    }

}
