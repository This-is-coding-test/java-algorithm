import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 편집_거리 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String from = br.readLine();
        String to = br.readLine();

        n = from.length(); // 행
        m = to.length(); // 열

        int[][] dp = new int[n + 1][m + 1];
        init(dp);
        for (int i = 1; i <= n; i++) {
            char c1 = from.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char c2 = to.charAt(j - 1);

                if (c1 == c2) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
            }
        }

        System.out.println(dp[n][m]);
    }

    private static void init(int[][] dp) {

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }


    }

}
