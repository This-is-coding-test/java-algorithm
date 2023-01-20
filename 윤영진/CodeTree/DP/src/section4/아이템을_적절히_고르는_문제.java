package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 아이템을_적절히_고르는_문제 {

    static final int n = 3, m = 8;
    static int[] coins = new int[]{2, 3, 5};
    static int[] dp = new int[m + 1];

    public static void init() {
        for (int i = 0; i <= m; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 0;
    }
    public static void main(String[] args) throws IOException {

        init();

        for (int coin : coins) {

            for (int i = coin; i <= m; i++) {
                if (dp[i] < dp[i - coin] + 1) {
                    dp[i] = dp[i - coin] + 1;
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            System.out.print(dp[i] + " ");
        }

        System.out.println(dp[m]);
    }
}
