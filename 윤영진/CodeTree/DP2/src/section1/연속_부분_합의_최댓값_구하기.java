package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속_부분_합의_최댓값_구하기 {
    static int n;
    static int[] a;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        a = new int[n + 1];
        dp = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        init();

        int ans = dp[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
            ans = Math.max(dp[i], ans);
        }

        System.out.println(ans);



    }

    private static void init() {
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[1] = a[1];
    }
}
