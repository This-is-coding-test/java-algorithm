package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서로_다른_BST_개수_세기_sol {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = backtracking(i);
        }
        System.out.println(dp[n]);
    }

    private static int backtracking(int n) {
        int numOfUniqueBst = 0;

        for (int i = 0; i < n; i++) {
            numOfUniqueBst += dp[i] * dp[n - i - 1];
        }
        return numOfUniqueBst;
    }
}
