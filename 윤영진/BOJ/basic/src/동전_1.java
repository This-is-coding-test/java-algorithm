import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전_1 {

    // n가지 종류의 동전이 있다.
    // 각각의 동전이 나타내는 가치는 다르다.
    // 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다.

    // 경우의 수
    // 각각의 동전은 몇 개라도 사용할 수 있다.

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
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin; // 1, 2, 5
        }

        for (int coin : coins) { // 1, 2, 5
            for (int i = 1; i <= k; i++) {
                if (coin <= i) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        System.out.println(dp[k]);


    }
}
