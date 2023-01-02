package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class k개_중에_1개를_n번_뽑기 {
    // 1 이상 K 이하의 숫자를 하나 고르는 행위를 N번 반복
    // 모든 서로 다른 순서쌍

    static int K, N;
    static int[] output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        output = new int[N];

        backtracking(0);
    }

    private static void backtracking(int depth) {

        if (depth == N) {

            for (int i = 0; i < N; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();

        } else {
            for (int i = 1; i <= K; i++) {
                output[depth] = i;
                backtracking(depth + 1);
            }
        }

    }
}
