package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 적절한_옷_고르기 {
    static class Clothes {
        int s;
        int e;
        int v;

        public Clothes(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }

    static int N, M;
    static Clothes[] clothes;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        clothes = new Clothes[N + 1];
        dp = new int[M + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            clothes[i] = new Clothes(s, e, v);
        }

        init();

        for (int i = 2; i <= M; i++) { // 날짜
            for (int j = 1; j <= N; j++) { // 옷 -> 1, 2, 3
                for (int k = 1; k <= N; k++) { // 옷 -> 1, 2, 3

                    // i - 1번째 날에 k번 옷을 입은 경우를 고려해봅니다.
                    // j번 옷이 i번째 날에 입을 수 있는 경우에만 고려해볼 수 있습니다.
                    Clothes prev = clothes[k];
                    Clothes curr = clothes[j];

                    if (prev.s <= i - 1 && i - 1 <= prev.e && curr.s <= i && i <= curr.e) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Math.abs(curr.v - prev.v));
                    }

                }

            }

        }

        int ans = 0;
        for (int j = 1; j <= N; j++)
            ans = Math.max(ans, dp[M][j]);

        System.out.println(ans);

    }

    private static void init() {

        for (int i = 1; i <= M; i++)
            for (int j = 1; j <= N; j++)
                dp[i][j] = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            if (clothes[i].s == 1) {
                dp[1][i] = 0;
            }

        }
    }
}
