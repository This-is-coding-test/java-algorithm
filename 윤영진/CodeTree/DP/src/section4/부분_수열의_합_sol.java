package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분_수열의_합_sol {
    static int n, m;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        dp = new boolean[n + 1][m + 1]; // i번째 수까지만 고려해봤을 때, j로 만드는 것이 가능?

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = true;

        for (int i = 1; i <= n; i++) { // 5, 2, 4, 9, 1
            for (int j = 0; j <= m; j++) {

                if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]])
                    dp[i][j] = true;

                // Case 2
                if (dp[i - 1][j])
                    dp[i][j] = true;

//                if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]]) { // i번째 수를 골라서 j가 되는 경우
//                    dp[i][j] = true;
//                }
//
//                if (dp[i - 1][j]) { // i번째 수를 고르지 않고 j가 되는 경우
//                    dp[i][j] = true;
//                }
            }
        }

        if (dp[n][m]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


    }
}
