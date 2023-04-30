import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _123_더하기_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[4][N + 1];
            init(dp, N);

            for (int num : new int[]{2, 3}) {
                for (int i = 0; i <= N; i++) {
                    if (num > i) dp[num][i] = dp[num - 1][i];
                    else {
                        dp[num][i] = dp[num - 1][i] + dp[num][i - num];
                    }
                }
            }
            sb.append(dp[3][N]).append("\n");
        }
        System.out.println(sb);
    }

    private static void init(int[][] dp, int n) {

        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;
        }

    }
}
