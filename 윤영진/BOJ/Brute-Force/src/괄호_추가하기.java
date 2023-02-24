import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 괄호_추가하기 {
    static int N;
    static List<Integer> nums = new ArrayList<>();
    static List<Character> ops = new ArrayList<>();
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        for (char c : chars) {
            if (Character.isDigit(c)) {
                nums.add(Integer.parseInt(String.valueOf(c)));
            } else {
                ops.add(c);
            }
        }

        dfs(0, nums.get(0));
        System.out.println(result);


    }

    private static void dfs(int depth, Integer sum) {
        if (depth == ops.size()) {
            result = Math.max(result, sum);
        } else {
            dfs(depth + 1, calc(sum, nums.get(depth + 1), ops.get(depth)));
            if (depth + 2 <= ops.size()) {
                dfs(depth + 2, calc(sum, calc(nums.get(depth + 1), nums.get(depth + 2), ops.get(depth + 1)), ops.get(depth)));
            }
        }
    }

    private static Integer calc(Integer a, Integer b, Character op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }
}
