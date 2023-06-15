import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 등차수열 {
    // 1 3 4 5 7
    // 1 3 5 7
    // 1 4 7
    static int N;
    static int[][] dp; // dp[i][j] (i < j) : i번째와 j번째가 마지막 두 항인 등차수열의 최대 길이 -> 공차 : nums[j] - nums[i]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }
        int[] nums = new int[N + 1];
        dp = new int[N + 1][N + 1];
        // 0 1 3 4 5 7
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        int answer = Integer.MIN_VALUE;

        for (int i = 1; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                dp[i][j] = 2;
                int diff = nums[j] - nums[i];
                for (int k = i - 1; k >= 1; k--) {
                    if (diff == nums[i] - nums[k]) {
                        dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                        break;
                    }
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}
