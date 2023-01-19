package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조건에_맞게_선택적으로_전진하는_DP {

    // dp[i]는 점프하여 도착한 마지막 위치를 i라 했을 때, 가능한 최대 점프 횟수
    static int n = 5;
    static int[] a = new int[]{2, 3, 0, 1, 4};
    static int[] dp = new int[n];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == Integer.MIN_VALUE) {
                    continue;
                }

                if (j + a[j] >= i) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }

    private static void init() {

        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 0;

    }
}
