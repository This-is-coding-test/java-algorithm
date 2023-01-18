package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 정수_사각형_차이의_최소_2 {

    // 최솟값을 1부터 100까지 일일일 가정해보며, 최솟값 이상의 수들만 써서 이동한다는 가정하에서 경로상에 놓여있는 수들 중 최댓값을 최소화 하는 문제를 해결
    // 주어진 수의 범위가 1에서 100사이로 작기 때문에 일일이 가정해보는 전략이 가능하다.

    // 최솟값 lower_bound가 정해져있다는 가정하에서는 최솟값 이상의 수들만 써서 이동한다는 가정하에서 경로상에 놓여있는 수들 중 최댓값을 최소화 하는 문제를 풀어 이로부터 나온 값을 upper_bound라 했을 때

    static int n;
    static int[][] map;
    static int[][] dp;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int lowerBound = 1; lowerBound <= 100; lowerBound++) {
            int upperBound = getUpperBound(lowerBound);

            if (upperBound != Integer.MAX_VALUE) {
                result = Math.min(result, upperBound - lowerBound);
            }

        }

        System.out.println(result);
    }

    private static int getUpperBound(int lowerBound) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] < lowerBound)
                    map[i][j] = Integer.MAX_VALUE;
            }
        }

        init();

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(Math.min(dp[i - 1][j], dp[i][j - 1]), map[i][j]);
            }
        }
        return dp[n - 1][n - 1];
    }

    private static void init() {
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = map[0][0];

        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(map[0][i], dp[0][i - 1]);
            dp[i][0] = Math.max(map[i][0], dp[i - 1][0]);
        }

    }

}
