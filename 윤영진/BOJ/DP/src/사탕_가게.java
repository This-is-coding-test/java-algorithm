import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 사탕_가게 {
    static class Info {
        int c, p;

        public Info(int c, int p) {
            this.c = c;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            double m = Double.parseDouble(st.nextToken());
            if (n == 0 && m == 0.00) break;

            int money = (int) (m * 100);
            int[] dp = new int[money + 1];

            ArrayList<Info> infos = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                double p = Double.parseDouble(st.nextToken());

                infos.add(new Info(c, (int) (p * 100.0 + 0.5)));
            }
            Collections.sort(infos, new Comparator<Info>() {
                @Override
                public int compare(Info o1, Info o2) {
                    return o1.p - o2.p;
                }
            });

            for (Info info : infos) {
                for (int i = info.p; i <= money; i++) {
                    dp[i] = Math.max(dp[i], dp[i - info.p] + info.c);
                }
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= money; i++) {
                max = Math.max(max, dp[i]);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
