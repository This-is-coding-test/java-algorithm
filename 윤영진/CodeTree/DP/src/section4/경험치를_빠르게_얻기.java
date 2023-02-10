package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경험치를_빠르게_얻기 {
    static class Quest {
        int e;
        int t;

        public Quest(int e, int t) {
            this.e = e;
            this.t = t;
        }
    }

    static int n, m;

    static Quest[] quests;
    static int[][] dp;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        quests = new Quest[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            quests[i] = new Quest(e, t);
            time += t;
        }

        dp = new int[n + 1][time + 1];

        init();

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= time; j++) {

                // 현재 퀘스트 포함한 최대 경험치
                if (j >= quests[i].t) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - quests[i].t] + quests[i].e);
                }

                // 현재 퀘스트 포함하지 않은 최대 경험치
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= time; i++) {
            if (dp[n][i] >= m) {
                ans = Math.min(ans, i);
            }
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);


    }

    private static void init() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= time; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
//        dp[0][0] = 0;
    }
}
