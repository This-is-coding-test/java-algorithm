package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 증가했다가_감소하는_부분_수열 {
    static int N;
    static int[][] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][2];

        for (int i = 0; i < N; i++) {

            dp[i][0] = 1;
            dp[i][1] = 1;

            for (int j = 0; j < i; j++) {

                // 증가
                if (arr[i] > arr[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }

                // 감소
                if (arr[i] < arr[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }

            }
            // 현재가 전환점인 경우
            dp[i][1] = Math.max(dp[i][0], dp[i][1]);
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}
