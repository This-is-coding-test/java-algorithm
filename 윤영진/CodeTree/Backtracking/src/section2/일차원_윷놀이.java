package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 일차원_윷놀이 {

    static int n, m, k;
    static List<Integer> output = new ArrayList<>();
    static int[] step;
    static int[] currStep;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        step = new int[n]; // 2, 4, 2, 4
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            step[i] = Integer.parseInt(st.nextToken());
        }

        currStep = new int[k];
        for (int i = 0; i < k; i++) {
            currStep[i] = 1;
        }


        backtracking(0);

        System.out.println(max);


    }

    private static void backtracking(int depth) {
        max = Math.max(max, findMaxCnt());
        if (depth == n) {
            return;
        }else {
            for (int i = 0; i < k; i++) {

                if (currStep[i] >= m) {
                    continue;
                }
                currStep[i] += step[depth];
                backtracking(depth + 1);
                currStep[i] -= step[depth];
            }

        }

    }

    private static int findMaxCnt() {

        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (currStep[i] >= m) cnt++;
        }

        return cnt;

    }
}
