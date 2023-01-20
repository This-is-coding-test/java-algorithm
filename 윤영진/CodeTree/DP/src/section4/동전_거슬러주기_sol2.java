package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

public class 동전_거슬러주기_sol2 {
    public static final int MAX_ANS = 10001;

    static int n, m;
    static Integer[] coins;
    static int minCnt = MAX_VALUE;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        coins = new Integer[n];
        memo = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = parseInt(st.nextToken());
        }

        initializeMemo();


        int minCnt = findMinCnt(0);
        if (minCnt == MAX_ANS) {
            minCnt = -1;
        }
        System.out.println(minCnt);
    }

    private static int findMinCnt(int sum) {
        if (memo[sum] != -1)
            return memo[sum];

        // 합이 m이 되면 동전이 추가적으로 필요 없으므로
        // 필요한 동전의 수 0을 반환 합니다.
        if (sum == m) {
            return memo[sum] = 0;
        }

        // 최소를 구하는 문제이므로
        // 초기값을 답이 될 수 있는 최대보다 조금 더 큰
        // MAX_ANS로 설정합니다.
        int minCnt = MAX_ANS;

        // 동전들을 하나씩 사용해봅니다.
        for (int i = 0; i < n; i++) {
            if (sum + coins[i] <= m)
                minCnt = Math.min(minCnt, findMinCnt(sum + coins[i]) + 1);
        }

        return memo[sum] = minCnt;

    }

    public static void initializeMemo() {
        for (int i = 0; i <= m; i++)
            memo[i] = -1;
    }
}
