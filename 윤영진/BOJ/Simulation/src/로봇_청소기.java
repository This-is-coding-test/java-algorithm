import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇_청소기 {
    static int N;
    static int M;
    static int[] dx = {-1, 0, 1, 0}; // 북동남서
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int answer = 1;

    // d: 0 -> 북, d: 1 -> 동, d: 2 -> 남, d: 3 -> 서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(r, c, d);

        System.out.println(answer);


    }

    private static void DFS(int x, int y, int dir) {

        map[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4; // dir = 0 -> 3
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                answer++;
                DFS(nx, ny, dir);
                return;
            }
        }

        // 후진
        int back = (dir + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];
        if (bx >= 0 && by >= 0 && bx < N && by < M && map[bx][by] != 1) {
            DFS(bx, by, dir);
        }


    }
}
