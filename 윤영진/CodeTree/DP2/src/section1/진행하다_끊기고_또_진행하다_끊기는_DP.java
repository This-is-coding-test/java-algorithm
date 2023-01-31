package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진행하다_끊기고_또_진행하다_끊기는_DP {

    // 선택한 연속 부분 수열의 마지막 원소의 위치가 같다면, 연속 부분 수열 내 원소의 합이 클수록 더 좋다.
    // dp[i] : 선택한 연속 부분 수열의 마지막 원소의 위치가 i라 했을 때, 얻을 수 있는 최대 점수

    public static final int n = 5;
    public static int[] a = new int[]{0, 4, -2, -5, 2, 2};
    public static int[] dp = new int[n + 1];


    public static void main(String[] args) throws IOException {
        init();

        for (int i = 2; i <= n; i++) {
            // 앞까지 더한값 or 현재 부분부터 시작
            dp[i] = Math.max(dp[i - 1] + a[i], a[i] * 2);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }

    private static void init() {
        for (int i = 1; i <= 5; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[1] = a[1] * 2;
    }
}
