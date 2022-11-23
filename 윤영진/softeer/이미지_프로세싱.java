package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이미지_프로세싱 {

    // H x M 크기의 2차원 비트맵 이미지가 있다.

    static int[][] map;
    static int H, M;

    static int Q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[H + 1][M + 1];

        for (int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (map[x][y] != c) {
                int old = map[x][y];
                map[x][y] = c;
                DFS(x, y, c, old);
            }
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void DFS(int x, int y, int c, int val) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && ny >= 1 && nx <= H && ny <= M) {
                if (val == map[nx][ny]) {
                    map[nx][ny] = c;
                    DFS(nx, ny, c, val);
                }
            }
        }

    }
}
