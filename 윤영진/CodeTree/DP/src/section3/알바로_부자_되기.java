package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 알바로_부자_되기 {

    static class Work implements Comparable<Work>{
        int s;
        int e;
        int p;

        public Work(int s, int e, int p) {
            this.s = s;
            this.e = e;
            this.p = p;
        }

        @Override
        public int compareTo(Work o) {
            return this.e - o.e;
        }
    }

    static int N;
    static List<Work> works = new ArrayList<>();

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            works.add(new Work(s, e, p));
        }

        Collections.sort(works);

        for (int i = 0; i < N; i++) {
            dp[i] = works.get(i).p;

            for (int j = 0; j < i; j++) {
                int start = works.get(i).s; // 3
                int end = works.get(j).e; //  2

                if (start > end) {
                    dp[i] = Math.max(dp[i], dp[j] + works.get(i).p);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
