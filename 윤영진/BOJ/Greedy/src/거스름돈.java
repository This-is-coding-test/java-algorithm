import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 거스름돈 {
    // 동전의 최소 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[]{2, 5};
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[n] == 987654321) dp[n] = -1;
        System.out.println(dp[n]);


    }
}
