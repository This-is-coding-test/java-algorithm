package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 동계_테스트_시점_예측 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // N x M
    // 얼음은 아침이 되면 기온이 상승하여 천천히 녹는다.
    // 정사각형 모양의 4변 중에서 적어도 2변 이상이 외부의 공기와 접촉했을 때 정확히 한 시간 만에 녹아 없어져 버린다.

    static int N, M;
    static int[][] map;
    static int[][] cnt;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cnt = new int[N][M];
        visited = new boolean[N][M];
        boolean flag = false;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    flag = true;
                }
            }
        }

        while (flag) {
            time++;
            DFS(0, 0);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (cnt[i][j] >= 2) map[i][j] = 0;
                }
            }
            flag = check();
            visited = new boolean[N][M];
            cnt = new int[N][M];

        }
        System.out.println(time);


    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                if (map[nx][ny] == 1) {
                    cnt[nx][ny]++;
                } else {
                    DFS(nx, ny);
                }
            }
        }
    }


    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

}

