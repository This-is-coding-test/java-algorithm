import java.util.ArrayList;
import java.util.HashSet;

public class 수식최대화 {
    ArrayList<Long> operandList = new ArrayList<>();
    ArrayList<Character> operatorList = new ArrayList<>();

    boolean[] visited;
    ArrayList<Character> output = new ArrayList<>();
    ArrayList<Character> opList = new ArrayList<>();
    long answer = 0;

    public long solution(String expression) {
        // 100 200 300 500 20
        // - * - +
        // 100 60000 500 20
        // - - +
        // 100 60000 520
        // - -
        // -59900 520
        // -
        // -60420


        String[] operands = expression.split("[-+*]");
        String[] operators = expression.split("[0-9]+");

        for (String operand : operands) {
            if (operand.isEmpty()) continue;
            operandList.add(Long.parseLong(operand));

        }

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].isEmpty()) continue;

            char opt = operators[i].charAt(0);
            operatorList.add(opt);
            if (!set.contains(opt)) {
                set.add(opt);
                opList.add(opt);
            }

        }
        visited = new boolean[opList.size()];
        dfs(0);

        return answer;
    }

    public void dfs(int depth) {
        if (depth == opList.size()) {
            System.out.println(opList);
            answer = Math.max(answer, solve());
        } else {
            for (int i = 0; i < opList.size(); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    output.add(opList.get(i));
                    dfs(depth + 1);
                    visited[i] = false;
                    output.remove(output.size() - 1);
                }
            }
        }
    }

    public long solve() {

        ArrayList<Long> opList = new ArrayList<>(operandList);
        ArrayList<Character> optList = new ArrayList<>(operatorList);

        for (char opt : output) { // - -> * -> +

            for (int i = 0; i < optList.size(); i++) {
                if (opt == optList.get(i)) {
                    Long n2 = opList.remove(i + 1);
                    Long n1 = opList.remove(i);
                    Character op = optList.remove(i);

                    Long res = calc(n1, n2, op);

                    opList.add(i, res);
                    i--;
                }
            }

        }
        return Math.abs(opList.get(0));
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
