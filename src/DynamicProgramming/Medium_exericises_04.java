package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * 120、最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 */
public class Medium_exericises_04 {

    /**
     * 1、确定base case      当元素为1时，最小值为arr[0][0]
     * 2、确定变量:往base case中靠近的量   高度在变
     * 3、确定选择：什么导致了变量在动态变化  索引的变化
     * 4、梳理出状态转移方程    f(n) = f(n-1)+min(i,i+1)
     *
     * @param args
     */


    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(Arrays.asList(-1),
                Arrays.asList(2,3),
                Arrays.asList(1, -1, -3)
                /*Arrays.asList(4, 1, 8, 3)*/);
        System.out.println(new Medium_exericises_04().minimumTotal(list));
    }

    /**
     * 动态规划
     * 思路：s[i+1]-s[j-1] 是回文，且s[i]=s[j]
     * 边缘条件： 当len = 1 时，回文， len = 2时， s[0]= s[1] 回文
     *
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (null == triangle || triangle.isEmpty()) return 0;
        int len = triangle.size();
        int[][] dp = new int[len][len];
        int size = triangle.get(len - 1).size()-1;
        int maxIndex = len-1 ;
        for(int i = 0;i<=size ;i++){
            dp[maxIndex][i] = triangle.get(maxIndex).get(i) ;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <=i; j++) {
                dp[i][j] =Math.min(dp[i + 1][j+1], dp[i + 1][j])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
