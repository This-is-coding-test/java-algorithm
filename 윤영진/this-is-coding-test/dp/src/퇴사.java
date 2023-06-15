import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] t = new int[N + 1];
        int[] p = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            t[i] = time;
            p[i] = price;
        }
        // dp[i] : i번째 날부터 마지막 날까지 낼 수 있는 최대 이익
        // dp[5] : 5일부터 일한 값 중 최댓값
        int[] dp = new int[N + 2];

        for (int i = N; i > 0; i--) {
            int time = t[i] + i;
            if (time <= N + 1) {
                dp[i] = Math.max(dp[i + 1], p[i] + dp[time]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);


    }
}
