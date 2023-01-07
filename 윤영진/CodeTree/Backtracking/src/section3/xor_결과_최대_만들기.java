package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class xor_결과_최대_만들기 {
    static int n, m;

    static int[] input;
    static List<Integer> output = new ArrayList<>();
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0, 0);
        System.out.println(result);
    }

    private static void backtracking(int depth, int start, int val) {

        if (depth == m) {
            result = Math.max(result, val);
        } else {
            for (int i = start; i < n; i++) {
                output.add(i);
                backtracking(depth + 1, i + 1, val ^ input[output.get(output.size() - 1)]);
                output.remove(output.size() - 1);
            }
        }
    }

    private static int calc() {
        int ans = input[output.get(0)];
        for (int i = 1; i < m; i++) {
            ans = ans ^ input[output.get(i)];
        }
        return ans;
    }
}
