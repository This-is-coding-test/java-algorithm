class 최대길이_바이토닉_수열_1 {
    static int[][] dp;
    static int n;

    public int solution(int[] nums) {
        int answer = 0;
        n = nums.length;
        dp = new int[n][2];
        int max = Integer.MIN_VALUE;
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            // 증가
            if (nums[i] > nums[i - 1]) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][0] + 1);
            }

            // 감소
            if (nums[i] < nums[i - 1]) {
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][1] + 1);
            }

            dp[i][1] = Math.max(dp[i][0], dp[i][1]);
            max = Math.max(max, dp[i][1]);
        }

        return max;
    }

    public static void main(String[] args) {
        최대길이_바이토닉_수열_1 T = new 최대길이_바이토닉_수열_1();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}