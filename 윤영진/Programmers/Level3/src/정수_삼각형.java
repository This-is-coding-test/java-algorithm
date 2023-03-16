public class 정수_삼각형 {
    static int[][] dp;
    static int n;

    public int solution(int[][] triangle) {
        int answer = 0;
        n = triangle.length;
        dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {

            dp[i][0] = triangle[i][0] + dp[i - 1][0];

            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }

        }

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }

        return answer;
    }
}
