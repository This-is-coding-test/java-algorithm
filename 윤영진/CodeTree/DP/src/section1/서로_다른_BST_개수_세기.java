package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서로_다른_BST_개수_세기 {
    static int N;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];
        memo[1] = 1;
        memo[2] = 2;

        backtracking(N);
        System.out.println(memo[N]);
    }

    private static int backtracking(int n) {

        if (memo[n] != 0) return memo[n];

        if (n <= 1) return 1;

        int numberOfUniqueBst = 0;
        for (int i = 0; i < n; i++) {
            numberOfUniqueBst += backtracking(i) * backtracking(n - i - 1);

        }
        return memo[n] = numberOfUniqueBst;

    }
}
