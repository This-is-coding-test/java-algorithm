import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알약 {
    // 첫째 날은 종수는 병에서 약 하나를 꺼낸다. 그 약을 반으로 쪼개서 한 조각은 먹고, 다른 조각은 다시 병에 넣는다.
    // 6
    // H 1
    // HW 2
    // HH 2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[31];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= 30; i++) {
            long cnt = 0;
            for (int j = 0; j < i; j++) {
                cnt += dp[j] * dp[i - 1 -j];
            }
            dp[i] = cnt;
        }

        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}
