package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일이오_더하기 {
    static int n;
    static int cnt = 0;
    static int[] nums = {1, 2, 5};
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i >= nums[j]) {
                    dp[i] = (dp[i] + dp[i - nums[j]]) % 10007;
                }
            }
        }
        System.out.println(dp[n]);
    }

}
