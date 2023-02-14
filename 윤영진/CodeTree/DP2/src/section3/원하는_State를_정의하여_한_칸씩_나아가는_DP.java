package section3;

public class 원하는_State를_정의하여_한_칸씩_나아가는_DP {

    // 홀수 번째 고른 숫자들은 더하고, 짝수 번째로 고른 숫자들은 빼서 얻을 수 있는 최댓값

    // 지금까지 고려한 숫자의 위치와 지금까지 선택한 숫자의 개수가 같다면, 지금까지의 계산 결과는 클수록 더 좋다.
    // dp[i][j] : i번째 숫자까지 고려했고 지금까지 숫자를 정확히 j개 골랐다고 했을 때, 얻을 수 있는 최대 결과

    static int n = 2;
    static int[] a = new int[]{0, 2, 4, 1, 6};
    static int[][] dp = new int[2 * n + 1][n + 1];

    public static void main(String[] args) {
        init();

        for (int i = 1; i <= n * 2; i++) {
            dp[i][0] = dp[i - 1][0];
            for (int j = 1; j <= n; j++) {
                if (j <= i){
                    if (j % 2 == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + a[i]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - a[i]);
                    }
                }

            }
        }

        System.out.println(dp[2 * n][n]);
    }

    private static void init() {
        for (int i = 0; i <= 2 *  n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        dp[0][0] = 0;

    }

}
