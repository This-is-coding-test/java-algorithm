package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소_점프_횟수_sol2 {
    // 각 위치로부터의 최대 점프 가능 거리를 의미하는 n개의 숫자
    // 첫 번째 위치로부터 n번째 위치에 도달하기 위해 필요한 최소 점프 횟수

    static int n;
    static int[] jumps;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        jumps = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(st.nextToken());
            jumps[i] = val;
        }

        backtracking(1, 1);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(result - 1);

    }

    private static void backtracking(int depth, int idx) {
        if (idx >= n) {
            result = Math.min(result, depth);
        } else {
            for (int dist = 1; dist <= jumps[idx]; dist++) {
                backtracking(depth + 1, idx + dist);
            }
        }

    }
}
