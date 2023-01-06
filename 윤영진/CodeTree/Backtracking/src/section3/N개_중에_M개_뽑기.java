package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N개_중에_M개_뽑기 {

    // 1이상 N이하의 숫자 중 M 개의 숫자를 골라 만들 수 있는 모든 조합

    static int N, M;
    static List<Integer> output = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backtracking(0, 1);
    }

    private static void backtracking(int depth, int start) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(output.get(i) + " ");
            }
            System.out.println();

        } else {
            for (int i = start; i <= N; i++) {
                output.add(i);
                backtracking(depth + 1, i + 1);
                output.remove(output.size() - 1);
            }
        }
    }

}
