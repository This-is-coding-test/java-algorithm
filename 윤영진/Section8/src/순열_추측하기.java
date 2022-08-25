import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열_추측하기 {

    static int N;
    static int F;

    static int[] b;
    static int[][] memo;
    static boolean[] ch;
    static int[] output;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 4 16
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        b = new int[N];
        ch = new boolean[N + 1];

        memo = new int[N + 1][N + 1];
        output = new int[N];

        for (int i = 0; i < N; i++) {
            b[i] = comb(N - 1, i);
        }

        DFS(0, 0);
    }

    private static void DFS(int L, int sum) {

        if (flag) return;
        if (L == N) {
            if (sum == F) {
                for (int x : output) {
                    System.out.print(x + " ");
                }
                flag = true;
            }

        } else {

            for (int i = 1; i <= N; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    output[L] = i;
                    DFS(L + 1, sum + (b[L] * output[L]));
                    ch[i] = false;
                }

            }

        }

    }

    private static int comb(int n, int r) {

        if (memo[n][r] != 0) {
            return memo[n][r];
        }
        if (r == 0 || n == r) {
            return 1;
        } else {
            return memo[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);

        }

    }
}
