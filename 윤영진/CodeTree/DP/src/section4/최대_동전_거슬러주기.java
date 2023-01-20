package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대_동전_거슬러주기 {
    static int n, m;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        coins = new int[n];
        dp = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        init();


        for (int coin : coins) {
            for (int i = coin; i <= m; i++) {
                if (dp[i - coin] == -1) continue;
                
                if (dp[i] < dp[i - coin] + 1) {
                    dp[i] = dp[i - coin] + 1;
                }
            }
        }
        System.out.println(dp[m]);

    }

    public static void init() {
        for (int i = 0; i <= m; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
    }
}
