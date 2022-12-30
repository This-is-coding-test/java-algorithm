package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위_던지기 {

    // n: 격자 크기
    // m: 주사위 굴릴 횟수
    // (r, c): 주사위 초기 위치

    // 일반적인 주사위가 주어졌다 했을 때, 윗면, 정면, 오른쪽면에 각각 어떤 숫자가 적혀 있는지로 명확히 정의할 수 있다.
    // 주사위가 놓여있는 상태(방향)을 정의하고, 주어진 방향으로 주사위를굴렸을 때 그 다음 상태를 정의

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, x, y;
    static int[][] map;
    static int u = 1;
    static int f = 2;
    static int r = 3;

    static int[] dx = {0, 0, -1, 1}; // 우, 좌, 상, 하
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        map[x][y] = 6;

        int[] dirMapper = new int[128];
        dirMapper['R'] = 0;
        dirMapper['L'] = 1;
        dirMapper['U'] = 2;
        dirMapper['D'] = 3;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            char c = st.nextToken().charAt(0);

            simulate(dirMapper[c]);
        }

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);

    }

    private static void simulate(int dir) {

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx <= 0 || ny <= 0 || nx > n || ny > n) return;

        x = nx;
        y = ny;

        int temp;
        if (dir == 0) {
            temp = r;
            r = u;
            u = 7 - temp;
        } else if (dir == 1) {
            temp = r;
            r = 7 - u;
            u = temp;
        } else if (dir == 2) {
            temp = f;
            f = 7 - u;
            u = temp;
        } else {
            temp = f;
            f = u;
            u = 7 - temp;
        }

        int down = 7 - u;
        map[x][y] = down;

    }
}
