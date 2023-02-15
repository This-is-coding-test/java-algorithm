import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영일타일 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        if(N <= 2) {
            System.out.println(N);
            return;
        }

        init();

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.println(dp[N]);


    }

    private static void init() {
        dp[1] = 1;
        dp[2] = 2;
    }
}
