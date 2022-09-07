import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌다리_건너기 {

    static int N;
    static int[] dp = new int[36];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[N + 1]);



    }
}
