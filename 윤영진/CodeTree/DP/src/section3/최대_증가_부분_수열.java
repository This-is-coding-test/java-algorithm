package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대_증가_부분_수열 {
    static int N;
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init();

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] == Integer.MIN_VALUE) dp[i] = 1;
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);

    }

    private static void init() {
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 1;

    }
}
