import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커_모으기_2 {
    static int dp[];

    public int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;
        if (len == 1) return sticker[0];
        dp = new int[len];
        // 첫번째 스티커 떼는 경우
        dp[0] = sticker[0];
        dp[1] = dp[0];

        for(int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }

        answer = dp[len-2];

        // 첫번째 스티커 떼지 않는 경우
        dp[0] = 0;
        dp[1] = sticker[1];

        for(int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }

        answer = Math.max(answer, dp[len-1]);

        return answer;
    }
}
