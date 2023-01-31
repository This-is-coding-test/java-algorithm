package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소_차_분할 {
    // n개의 수가 주어졌을 때 이를 정확히 2개의 그룹 A, B로 나누어 A에 들어있는 수들의 합과
    // dp[i][j] == i번째 까지 고려했을 때 j가 될 수 있는지
    static int n, m; // m은 전체합
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            m += arr[i];
        }
        dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= m; j++) {
                if (j >= arr[i] && dp[i - 1][j - arr[i]]) {// i번째를 선택해서 j가 되는 경우
                    dp[i][j] = true;
                }
                if (dp[i - 1][j]) { // i번째를 선택하지 않고 j가 되는 경우 -> 앞에서 이미 j가 되는 겨웅
                    dp[i][j] = true;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= m; i++) {
            if (dp[n][i]) {
                min = Math.min(min, Math.abs(i - (m - i)));
            }
        }
        System.out.println(min);

    }


}
