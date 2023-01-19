package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 겹치지_않게_선분_고르기_2 {
    static class Line implements Comparable<Line> {
        int a;
        int b;

        public Line(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Line l) {
            return this.a - l.a;
        }

    }

    static int n;
    static int[] dp;
    static List<Line> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines.add(new Line(a, b));
        }
        dp = new int[n];
        Collections.sort(lines);

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                int next = lines.get(i).a; // 뒷 선분
                int prev = lines.get(j).b;

                if (!intersect(prev, next)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

        }


        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }

    private static boolean intersect(int prev, int next) {
        return !(prev < next);
    }


}
