import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합분해 {

    static final int MOD = 1000000000;
    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K + 1][N + 1];

        init();

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                dp[i][j] %= MOD;
//                for (int k = 0; k <= j; k++) {
//                    dp[i][j] += dp[i - 1][k];
//                    dp[i][j] %= MOD;
//                }
            }
        }

        System.out.println(dp[K][N]);

    }

    private static void init() {

        // 열 초기화
        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }

        // 행 초기화
        for (int j = 0; j <= N; j++) {
            dp[1][j] = 1;
        }


    }
}
