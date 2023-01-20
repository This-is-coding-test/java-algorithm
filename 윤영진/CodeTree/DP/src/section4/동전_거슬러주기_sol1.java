package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class 동전_거슬러주기_sol1 {

    static int n, m;
    static Integer[] coins;
    static int minCnt = MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        coins = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = parseInt(st.nextToken());
        }

        Arrays.sort(coins, Collections.reverseOrder());

        findMinCnt(0, 0);
        if (minCnt == MAX_VALUE) {
            minCnt = -1;
        }
        System.out.println(minCnt);
    }

    private static void findMinCnt(int depth, int sum) {
        if (minCnt <= depth) return;
        if (sum == m) {
            minCnt = Math.min(minCnt, depth);
        } else {
            for (int coin : coins) { // 1,2,4
                if (sum + coin <= m) {
                    findMinCnt(depth + 1, sum + coin);
                }
            }

        }

    }
}
