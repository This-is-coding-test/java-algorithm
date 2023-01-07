package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이n개_중에_n개의_숫자를_적절하게_고르기_sol1 {
    static int n;
    static int[] nums;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        nums = new int[2 * n];
        visited = new boolean[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);
        System.out.println(result);
    }

    private static void backtracking(int depth, int cnt) {

        if (cnt == n) {
            result = Math.min(result, calc());
            return;
        }
        if (depth == 2 * n) return;

        visited[depth] = true;
        backtracking(depth + 1, cnt + 1);

        visited[depth] = false;
        backtracking(depth + 1, cnt);
    }

    private static int calc() {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < 2 * n; i++) {
            if (visited[i]) {
                sum1 += nums[i];
            } else {
                sum2 += nums[i];
            }
        }
        return Math.abs(sum1 - sum2);

    }
}
