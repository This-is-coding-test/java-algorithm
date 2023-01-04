package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class K개_중_하나를_N번_선택하기 {

    // 이전에 Section1의 2진수 문제(k개 중에 1개를 n번 뽑기)에서 "0이 인접해서 등장하지 않는 수"라는 조건이 추가된다면?
    // 0을 추가하기 위한 조건만 넣어주면 된다.
    // 1의 경우에는 항상 추가해도 되자만, 인접한 00을 만들지 않기 위해서는 0의 경우에 최초로 추가하는 0이거나
    // 바로 직전의 숫자가 0이 아니었을 경우에만 추가
    static int n;
    static List<Integer> output = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        backtracking(0);
    }

    private static void backtracking(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(output.get(i) + " ");
            }
            System.out.println();
        } else {
            if (depth == 0 || output.get(output.size() - 1) != 0) {
                output.add(0);
                backtracking(depth + 1);
                output.remove(output.size() - 1);
            }
            output.add(1);
            backtracking(depth + 1);
            output.remove(output.size() - 1);
        }

    }
}
