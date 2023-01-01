package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 합쳐지는_구슬들 {

    // 구슬마다 무게
    // 구슬이 합쳐지는 경우에 방향은 합쳐진 구슬들 중 가장 큰 번호가 매겨져있는 구슬의 방향

    // t초가 지난 이후에도 여전히 격자 안에 남아있는 구슬의 개수와 가장 무거운 구슬의 무게를 출력

    static class Marble {
        int i;
        int w;
        int d;

        public Marble(int i, int w, int d) {
            this.i = i;
            this.w = w;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Marble{" +
                    "i=" + i +
                    ", w=" + w +
                    ", d=" + d +
                    '}';
        }
    }

    static class Point {
        int x;
        int y;
        int dir;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.dir = d;
        }


    }

    static int n, m, t;
    static Marble[][] map;
    static Marble[][] nextMap;

    static int[] dx = {-1, 0, 0, 1}; // 상우좌하 -> 대칭 처리
    static int[] dy = {0, 1, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new Marble[n][n];
        nextMap = new Marble[n][n];

        int[] dirMapper = new int[128];
        dirMapper['U'] = 0;
        dirMapper['R'] = 1;
        dirMapper['L'] = 2;
        dirMapper['D'] = 3;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                map[i][j] = new Marble(-1, 0, 0);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            char d = st.nextToken().charAt(0);
            int w = Integer.parseInt(st.nextToken());

            map[r][c] = new Marble(i + 1, w, dirMapper[d]);
        }

        while (t-- > 0) {
            simulate();
        }

        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].i != -1) {
                    cnt++;
                    max = Math.max(max, map[i][j].w);
                }
            }
        }

        System.out.print(cnt + " " + max);

    }

    private static void simulate() {





        // Step1. nextMap 를 초기화
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                nextMap[i][j] = new Marble(-1, 0, 0);


        // Step2
        // 구슬을 전부 한 번씩 움직여 봅니다. && 합치기
        moveAllAndCombine();


        // Step3
        // nextMap -> Map
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = nextMap[i][j];
            }
        }

    }


    private static void moveAllAndCombine() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (map[i][j].i != -1) {
                    move(i, j);
                }
            }
        }
    }

    private static void move(int x, int y) {

        int idx = map[x][y].i;
        int weight = map[x][y].w;
        int dir = map[x][y].d;

        Point nP = nextPos(x, y, dir);

        int prevIdx = nextMap[nP.x][nP.y].i;
        int prevWeight = nextMap[nP.x][nP.y].w;
        int prevDir = nextMap[nP.x][nP.y].d;

        // 새롭게 들어온 구슬의 번호가 높은 경우 -> 인덱스, 무게, 방향 갱신
        if (prevIdx < idx) {
            nextMap[nP.x][nP.y] = new Marble(idx, weight + prevWeight, nP.dir);
        }
        // 기존의 구슬의 번호가 높은 경우 -> 무게만 갱신
        else {
            nextMap[nP.x][nP.y] = new Marble(prevIdx, prevWeight + weight, prevDir);
        }

    }

    private static Point nextPos(int x, int y, int dir) {

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0 || ny < 0 || nx >= n || ny >= n) { // 벽 O
            int newDir = 3 - dir;
            return new Point(x, y, newDir);
        } else {
            return new Point(nx, ny, dir);
        }

    }
}
