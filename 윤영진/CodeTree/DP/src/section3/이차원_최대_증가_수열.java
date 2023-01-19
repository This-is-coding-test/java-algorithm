package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이차원_최대_증가_수열 {
    // 특정 룰을 만족하면서 밟을 수 있는 칸의 최대 수
    // 항상 큰 수로 점프
    // 점프 진행시 현재 위치에서 적어도 한칸 이상 오른쪽에 있는 위치
    // 적어도 한칸 이상 아래쪽에 있는 위치
    static int n, m;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        init();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                for (int k = 0; k < i; k++) {
                    for (int l = 0; l < j; l++) {

                        if (dp[k][j] == Integer.MIN_VALUE) continue;

                        if (map[i][j] > map[k][l]) {
                            dp[i][j] = Math.max(dp[i][j], dp[k][l] + 1);
                        }
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);


    }

    private static void init() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 1;
    }
}
