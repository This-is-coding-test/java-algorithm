import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오르막_수 {

    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][10];

        init();

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                    
                }
            }
        }
        int sum = 0;
        for (int j = 0; j < 10; j++) {
            sum += dp[N][j];
        }
        System.out.println(sum);
    }

    private static void init() {

        for (int j = 0; j < 10; j++) {
            dp[1][j] = 1;
        }

    }

}
