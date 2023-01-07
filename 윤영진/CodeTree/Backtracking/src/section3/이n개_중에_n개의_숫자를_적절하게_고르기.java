package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이n개_중에_n개의_숫자를_적절하게_고르기 {
    static int n;
    static int[] nums;
    static List<Integer> selectedNums = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);
        System.out.println(result);
    }

    private static void backtracking(int depth, int start) {

        if (depth == n) {
            result = Math.min(result, calc());


        } else {
            for (int i = start; i < 2 * n; i++) {
                selectedNums.add(i);
                backtracking(depth + 1, i + 1);
                selectedNums.remove(selectedNums.size() - 1);
            }
        }

    }

    private static int calc() {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < 2 * n; i++) {
            if (selectedNums.contains(i)) {
                sum1 += nums[i];
            } else {
                sum2 += nums[i];
            }
        }
        return Math.abs(sum1 - sum2);

    }
}
