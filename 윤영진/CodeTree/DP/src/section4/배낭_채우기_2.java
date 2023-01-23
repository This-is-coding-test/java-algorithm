package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 배낭_채우기_2 {

    // N개의 보석의 정보
    // 무게의 합이 M을 넘지 않도록 하면서 가치의 합이 최대
    static class Jewel {
        int w;
        int v;

        public Jewel(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    static int N, M;
    static List<Jewel> jewelList = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewelList.add(new Jewel(w, v));
        }
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (Jewel jewel : jewelList) {
            for (int i = jewel.w; i <= M; i++) {
                if (dp[i] < dp[i - jewel.w] + jewel.v ) {
                    dp[i] = dp[i - jewel.w] + jewel.v;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= M; i++) {
            max = Math.max(max, dp[i]);
        }
        

        System.out.println(max);

    }
}
