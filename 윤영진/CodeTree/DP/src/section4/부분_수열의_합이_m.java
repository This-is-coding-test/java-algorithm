package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분_수열의_합이_m {
    static int n, m;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        dp = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for (int v : arr) {
            for (int i = m; i >= v; i--) {
                dp[i] = Math.min(dp[i], dp[i - v] + 1);
            }
        }

        if (dp[m] == 101) {
            dp[m] = -1;
        }
        System.out.println(dp[m]);


    }

    private static void init() {
        for (int i = 0; i <= m; i++) {
            dp[i] = 101;
        }
        dp[0] = 0;
    }
}
