import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수도배관공사 {

    static class Info {
        int l, p;

        public Info(int l, int p) {
            this.l = l;
            this.p = p;
        }
    }

    static int D, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int[] dp = new int[D + 1]; // 길이가 i일때 최대 용량
        ArrayList<Info> infos = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            infos.add(new Info(l, c));
        }
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = Integer.MAX_VALUE;

        for (Info info : infos) {
            for (int i = D; i >= info.l; i--) {
                if (dp[i - info.l] != Integer.MIN_VALUE) {
                    dp[i] = Math.max(dp[i], Math.min(dp[i - info.l], info.p));
                }
            }
        }
        System.out.println(dp[D]);
    }
}
