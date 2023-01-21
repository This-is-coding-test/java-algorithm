package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 막대기_나누기 {
    static class Bar {
        int len;
        int val;

        public Bar(int len, int val) {
            this.len = len;
            this.val = val;
        }
    }

    static int n;
    static Bar[] bars;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        bars = new Bar[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(st.nextToken());
            bars[i - 1] = new Bar(i, val);
        }

        for (Bar bar : bars) { // 1, 2, 3, 4
            for (int i = bar.len; i <= n; i++) {
                dp[i] = Math.max(dp[i], dp[i - bar.len] + bar.val);
            }
        }

        System.out.println(dp[n]);

    }

    private static void print() {
        for (int i = 1; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }
}
