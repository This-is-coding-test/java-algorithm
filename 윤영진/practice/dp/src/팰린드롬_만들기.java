import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팰린드롬_만들기 {
    // dp[i][j] : i번째부터 j번째 까지의 부분수열을 팰린드롬을 만들기 위해 끼워 넣어야 할 수의 최소 개수
    // dp[1][N] : 정답
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (arr[j] == arr[j + i]) { // j - 2, i - 5
                    dp[j][j + i] = dp[j + 1][j + i - 1];
                } else { // j - 1, j + i - 2
                    dp[j][j + i] = Math.min(dp[j + 1][j + i], dp[j][j + i - 1]) + 1;
                }
            }
        }

        System.out.println(dp[1][N]);

    }
}
