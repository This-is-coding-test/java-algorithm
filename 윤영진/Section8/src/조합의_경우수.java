import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합의_경우수 {

    // 조합 정리 -> 5C3 = 4C2 + 4C3 -> why?
    // {1, 2, 3, 4, 5}
    // 5명 중에 3명을 뽑는 경우의 수는
    // 5번 학생의 기준으로 5번이 참가한 경우와 참가하지 않은 경우로 나눌 수 있다.
    // 5번이 참가한 경우 { , , 5} -> 4명 중에 2명을 뽑는 경우의 수 == 4C2
    // 5번이 참가하지 않은 경우 { , , } -> 4명 중에 3명을 뽑는 경우의 수 == 4C3
    static int N;
    static int M;

    static boolean[] ch;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ch = new boolean[N];
        memo = new int[N + 1][M + 1];

        int result = DFS(N, M);
        System.out.println(result);


    }

    private static int DFS(int n, int r) {

        if (memo[n][r] != 0) {
            return memo[n][r];
        }
        if (r == 0 || n == r) {
            return 1;
        } else {
            return memo[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);

        }

    }
}
