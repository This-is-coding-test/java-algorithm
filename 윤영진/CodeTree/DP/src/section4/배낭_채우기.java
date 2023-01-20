package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배낭_채우기 {
    static class Bag {
        int w;
        int v;

        public Bag(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    static int N, M;
    static Bag[] bags;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bags = new Bag[N];
        dp = new int[M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            bags[i] = new Bag(w, v);
        }

        for (Bag bag : bags) {
            for (int i = M; i >= bag.w; i++) {
                dp[i] = Math.max(dp[i], dp[i - bag.w] + bag.v);
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= M; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);


    }
}
