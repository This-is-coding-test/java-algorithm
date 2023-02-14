import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리 {

    static int N;
    static int[][] colors;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        colors = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            colors[i][0] = r;
            colors[i][1] = g;
            colors[i][2] = b;
        }
        init();

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) { // 현재 옷
                for (int k = 0; k < 3; k++) { // 이전 옷
                    if (j != k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + colors[i][j]);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, dp[N - 1][i]);
        }
        System.out.println(ans);

    }

    private static void init() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = colors[0][i];
        }
    }
}
