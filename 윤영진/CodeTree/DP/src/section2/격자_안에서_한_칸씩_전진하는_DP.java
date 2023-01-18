package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 격자_안에서_한_칸씩_전진하는_DP {

    // 마지막으로 방문한 위치
    // 이동한 경로 상의 숫자 합

    // 위의 두 조건이 맞으면 동일한 상황

    // dp[i][j] == 마지막으로 방문한 위치를 (i, j)라 했을 때, 얻을 수 있는 최대 합

    public static int n = 4;
    public static int[][] a = {
            {4},
            {6, 2},
            {3, 7, 9},
            {3, 4, 9, 9}
    };
    public static int[][] dp = new int[4][4];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + a[i][j], dp[i - 1][j] + a[i][j]);
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) { //
            result = Math.max(result, dp[n - 1][i]);
        }
        System.out.println(result);

    }

    private static void init() {
        dp[0][0] = a[0][0];

        // 가장 왼쪽 열 채우기
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + a[i][0];
        }

        // 대각성 채우기
        for (int i = 1; i < n; i++) {
            dp[i][i] = dp[i - 1][i - 1] + a[i][i];
        }
    }
}
