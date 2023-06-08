import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            int m = (int) (Math.round(Double.parseDouble(st.nextToken()) * 100.0));
            if (n == 0 && m == 0) break;

            Info[] infos = new Info[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = (int) (Math.round(Double.parseDouble(st.nextToken()) * 100.0));
                infos[i] = new Info(c, p);
            }
            int[] dp = new int[m + 1];

            for (Info f : infos) {
                for (int i = f.p; i <= m; i++) {
                    dp[i] = Math.max(dp[i], dp[i - f.p] + f.c);
                }
            }

            sb.append(dp[m]).append("\n");
        }
        System.out.println(sb);


    }
}