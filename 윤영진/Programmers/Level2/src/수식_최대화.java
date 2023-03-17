import java.util.*;

public class 수식_최대화 {

    static long answer = 0;
    static List<Long> numsList = new ArrayList<>();
    static List<Character> opsList = new ArrayList<>();
    static boolean[] visited = new boolean[3];
    static Character[] output = new Character[3];
    static Character[] ops = new Character[]{'*', '+', '-'};

    public long solution(String expression) {
        StringBuilder sb = new StringBuilder();

        for (Character c : expression.toCharArray()) {
            if (c == '*' || c == '+' || c == '-') {
                opsList.add(c);
                numsList.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        numsList.add(Long.parseLong(sb.toString()));

        dfs(0);

        return answer;
    }

    public void dfs(int depth) {
        if (depth == 3) {
            solve();
        } else {
            for (int i = 0; i < 3; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    output[depth] = ops[i];
                    dfs(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public void solve() {

        List<Long> nums = new ArrayList<>();
        nums.addAll(numsList);

        List<Character> ops = new ArrayList<>();
        ops.addAll(opsList);

        for (int i = 0; i < 3; i++) {
            Character currOp = output[i]; // *

            for (int j = 0; j < ops.size(); j++) {
                if (ops.get(j) == currOp) {
                    Long n2 = nums.remove(j + 1);
                    Long n1 = nums.remove(j);
                    Character op = ops.remove(j);

                    Long res = calc(n1, n2, op);

                    nums.add(j, res);
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(nums.get(0)));
    }

    public Long calc(Long n1, Long n2, Character op) {
        if (op == '*') {
            return n1 * n2;
        } else if (op == '+') {
            return n1 + n2;
        } else {
            return n1 - n2;
        }
    }
}
