import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전_2 {

    static int n, k;
    static int[] coins, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }

        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int coin : coins) { // 1, 5, 12
            for (int i = coin; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[k] == 10001) {
            System.out.println(-1);
        }else {
            System.out.println(dp[k]);
        }


    }
}
