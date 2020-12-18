package DynamicProgramming;

/**
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 */
public class Medium_exericises_02 {

    /**
     * 思路：
     * 1、base case  不买入为0
     * 2、分两种情况  今天不持有： f0(n) = max(f0(n-1),f1(n-1)+prices[i]-fee)  昨天不持有，今天也不持有
     *              今天持有：   f1(n) = max(f1(n-1),f0(n-1)-prices[i])
     *
     */

    public static void main(String[] args) {
        int[] coins ={1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(new Medium_exericises_02().maxProfit(coins, fee));
    }

    /**  因为总是跟前一天有关，故可以去掉第一位 减少复杂度
     * @param coins
     * @param fee
     * @return
     */
    public int maxProfit(int[] coins, int fee) {
        int[][] fn  = new int[coins.length][2] ;
        fn[0][0] = 0 ;
        fn[0][1] = -coins[0];
        for (int i=1;i<coins.length;i++){
            fn[i][0] = Math.max(fn[i-1][0], fn[i-1][1]+coins[i]-fee ) ;
            fn[i][1] = Math.max(fn[i-1][1],fn[i-1][0]-coins[i]) ;
        }
      return fn[coins.length-1][0] ;
    }
}
