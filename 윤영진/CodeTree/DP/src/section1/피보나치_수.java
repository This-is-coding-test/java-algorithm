package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치_수 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 1 || N == 2) {
            System.out.print(1);
            return;
        }
        dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[N]);

    }
}
