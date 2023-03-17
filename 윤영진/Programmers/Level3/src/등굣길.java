public class 등굣길 {
    static int[][] dp;

    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n + 1][m + 1];

        for (int i = 0; i < puddles.length; i++) {
            int row = puddles[i][1];
            int col = puddles[i][0];
            dp[row][col] = -1;
        }

        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i != 1) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j != 1) {
                    dp[i][j] += dp[i][j - 1];
                }
                dp[i][j] %= 1000000007;

            }
        }

        return dp[n][m];
    }


}
