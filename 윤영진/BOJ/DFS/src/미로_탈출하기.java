import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로_탈출하기 {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dp;

    static int result = 0;

    // U -> (-1, 0)
    // R -> (0, 1)
    // D -> (1, 0)
    // L -> (0, -1)

    // 탈출 가능한 칸이란, 그 칸에서 이동을 시작해서 적힌대로 이동했을 때, 미로의 경계 밖으로 이동하게 되는 칸


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (DFS(i, j) == 1) {
                    dp[i][j] = 1;
                    result++;
                }
            }
        }

        System.out.println(result);

    }

    private static int DFS(int r, int c) {

        if (map[r][c] == 'U') {
            r -= 1;
        } else if (map[r][c] == 'R') {
            c += 1;
        } else if (map[r][c] == 'D') {
            r += 1;
        } else {
            c -= 1;
        }
        if (r < 0 || c < 0 || r >= N || c >= M) {
            return 1;
        }

        if (visited[r][c]) {
            if (dp[r][c] == 0) {
                return 0;
            } else {
                return 1;
            }
        }else {
            visited[r][c] = true;
            dp[r][c] = DFS(r, c);
            return dp[r][c];
        }


    }
}
