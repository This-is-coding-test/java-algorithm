package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_사각형_최댓값의_최소 {
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
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(Math.max(dp[i - 1][j], map[i][j]), Math.max(dp[i][j - 1], map[i][j]));
            }
        }
        System.out.print(dp[n - 1][n - 1]);


    }

    private static void init() {

        dp[0][0] = map[0][0];
        // 1행, 1열 초기화
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(map[0][i], dp[0][i - 1]);
            dp[i][0] = Math.max(map[i][0], dp[i - 1][0]);
        }

    }

}
