package DynamicProgramming;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class Medium_exericises_01 {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount =11;
        System.out.println(new Medium_exericises_01().coinChange(coins, amount));
    }

    /**
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        /**
         * f(n) = 0 amount = 0
         * f(n) = f(n-1) +1 amount >0
         */
        int res = Integer.MAX_VALUE;
        if (amount == 0) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = res ;
            for (int coin : coins) {
                if (i - coin < 0 ) {
                    dp[i] =Math.min(dp[i],res) ;
                } else {
                    dp[i] = Math.min(dp[i],  dp[i - coin]==res?res:dp[i-coin]+1);
                }


            }
        }

        return dp[amount] == res ? -1 : dp[amount];
    }
}
