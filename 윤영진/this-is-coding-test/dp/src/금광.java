import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금광 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];

            // 376
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[n + 2][m];
            init(arr, dp, n);

            for (int col = 1; col < m; col++) {
                for (int row = 1; row <= n; row++) {
                    dp[row][col] = Math.max(dp[row - 1][col - 1], Math.max(dp[row][col - 1], dp[row + 1][col - 1])) + arr[row - 1][col];
                }
            }

            int answer = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                answer = Math.max(answer, dp[i][m - 1]);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void init(int[][] arr, int[][] dp, int row) {

        for (int i = 0; i < row; i++) {
            dp[i + 1][0] = arr[i][0];
        }
    }
}