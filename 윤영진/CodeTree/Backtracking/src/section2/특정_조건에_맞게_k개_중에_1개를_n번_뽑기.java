package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 특정_조건에_맞게_k개_중에_1개를_n번_뽑기 {

    // 1이상 K이하의 숫자를 하나 고르는 행위를 N번 반복하여 나올 수 있는 모든 서로 다른 순서쌍
    // 단, 연속하여 같은 숫자가 3번 이상 나오는 경우는 제외
    static int K, N;
    static List<Integer> output = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        backtracking(0);
    }

    private static void backtracking(int depth) {
        if (depth == N) {
            for (int i = 0; i < output.size(); i++) {
                System.out.print(output.get(i) + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= K; i++) {
                if (depth >= 2) {
                    if (output.get(depth - 1) != i && output.get(depth - 2) != i) {
                        output.add(i);
                        backtracking(depth + 1);
                        output.remove(output.size() - 1);
                    }
                } else {
                    output.add(i);
                    backtracking(depth + 1);
                    output.remove(output.size() - 1);
                }

            }
        }

    }

    private static boolean check(int depth, int value) {

        for (int i = depth - 2; i < depth ; i++) {
            if (value != output.get(i)) return true;
        }
        return false;
    }
}
