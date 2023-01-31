package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속적이지만_직전_상황에_영향을_받는_DP {
    static int n, m;
    static int[][] map;
    static int[][] dp;


    // dp[i][j] : i번째 숫자까지 전부 선택을 완료했고, 마지막으로 고른 숫자의 위치가 j
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        init();

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= m; k++) {
                    if (j != k) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + map[i][j]);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = Math.max(ans, dp[n][i]);
        }

        System.out.println(ans);


    }

    private static void init() {

        for (int i = 1; i <= m; i++) {
            dp[1][i] = map[1][i];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

    }
}
