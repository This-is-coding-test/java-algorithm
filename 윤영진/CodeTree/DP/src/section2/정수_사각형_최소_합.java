package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_사각형_최소_합 {

    static int n;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        init();

        for (int i = 1; i < n; i++) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j + 1]) + map[i][j];
            }
        }

        System.out.println(dp[n - 1][0]);
    }

    private static void init() {

        dp[0][n - 1] = map[0][n - 1];
        // 1행, N열 초기화
        for (int i = n - 2; i >= 0; i--) {
            dp[0][i] = dp[0][i + 1] + map[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][n - 1] = dp[i - 1][n - 1] + map[i][n - 1];
        }


    }
}
