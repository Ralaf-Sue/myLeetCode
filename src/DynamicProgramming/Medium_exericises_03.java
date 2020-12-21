package DynamicProgramming;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class Medium_exericises_03 {

    /**
     * 1、确定base case      len =1 , 回文  len =2 , s.charAt[0] = s.charAt[1]
     * 2、确定变量:往base case中靠近的量   差值
     * 3、确定选择：什么导致了变量在动态变化  索引的变化
     * 4、梳理出状态转移方程    dp[i][j] = dp[i+1][j-1] && s.charAt[i] ==s.charAt[j]
     *
     * @param args
     */


    public static void main(String[] args) {
        String s = "abb";
        System.out.println(new Medium_exericises_03().longestPalindrome2(s));
    }

    /**
     * 动态规划
     * 思路：s[i+1]-s[j-1] 是回文，且s[i]=s[j]
     * 边缘条件： 当len = 1 时，回文， len = 2时， s[0]= s[1] 回文
     *
     * @return
     */
    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0) return "";
        String newStr = "";
        int len = s.length();
        boolean[][] sto = new boolean[len][len];
        for (int cha = 0; cha < len; cha++) {
            for (int i = 0; i + cha < len; i++) {
                int j = i + cha;
                if (cha == 0) {
                    sto[i][j] = true;
                } else if (cha == 1) {
                    sto[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    sto[i][j] = sto[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (sto[i][j] && j - i + 1 > newStr.length()) {
                    newStr = s.substring(i, j + 1);
                }

            }
        }

        return newStr;
    }

    /**
     * 中心扩散法
     * 分两种情况：以单字符扩散  以双字符扩散
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (null == s || s.length() == 0) return "";
        int len = s.length();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < len - 1; i++) {
            left = i;
            right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (maxLen < right - left - 1) {
                startIndex = left + 1;
                endIndex = right;
                maxLen = right - left - 1;
            }
        }
        for (int i = 0; i < len; i++) {
            left = right = i;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (maxLen < right - left - 1) {
                startIndex = left + 1;
                endIndex = right;
                maxLen = right - left - 1;
            }
        }

        return s.substring(startIndex, endIndex);
    }
}
