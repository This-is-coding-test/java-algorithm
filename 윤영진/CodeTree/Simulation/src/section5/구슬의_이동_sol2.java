package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 구슬의_이동_sol2 {

    static class Marble implements Comparable<Marble> {
        int i;
        int v;
        int d;

        public Marble(int i, int v, int d) {
            this.i = i;
            this.v = v;
            this.d = d;
        }



        @Override
        public int compareTo(Marble o) {
            if (this.v == o.v) return o.i - this.i;
            return o.v - this.v;
        }
    }

    static class Point {
        int x;
        int y;
        int d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }


    }

    static int n, m, t, k;
    static ArrayList<Marble>[][] map;
    static ArrayList<Marble>[][] nextMap;

    static int[] dx = {-1, 0, 0, 1}; // 상우좌하 -> 대칭 처리
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new ArrayList[n][n];
        nextMap = new ArrayList[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                map[i][j] = new ArrayList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                nextMap[i][j] = new ArrayList<>();

        int[] dirMapper = new int[128];
        dirMapper['U'] = 0;
        dirMapper['R'] = 1;
        dirMapper['L'] = 2;
        dirMapper['D'] = 3;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            char d = st.nextToken().charAt(0);
            int v = Integer.parseInt(st.nextToken());

            map[r][c].add(new Marble(i + 1, v, dirMapper[d]));
        }

        while (t-- > 0) {
            simulate();
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt += map[i][j].size();
            }
        }
        System.out.println(cnt);


    }

    private static void simulate() {

        // Step1. nextMap 를 초기화
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                nextMap[i][j] = new ArrayList<>();


        // Step2
        // 구슬을 전부 한 번씩 움직여 봅니다.
        moveAll();

        // Step3
        // 각 칸마다 구슬이 최대 k개만 있도록 조정합니다.
        selectMarbles();

        // Step4
        // nextMap -> Map
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = (ArrayList<Marble>) nextMap[i][j].clone();
            }
        }
    }

    private static void selectMarbles() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nextMap[i][j].size() > k) {

                    Collections.sort(nextMap[i][j]);
                    while (nextMap[i][j].size() > k) {
                        nextMap[i][j].remove(nextMap[i][j].size() - 1); // 우선순위 가장 낮은 구슬 삭제
                    }
                }
            }
        }

    }


    private static void moveAll() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < map[i][j].size(); k++) {
                    int v = map[i][j].get(k).v;
                    int idx = map[i][j].get(k).i;
                    int dir = map[i][j].get(k).d;

                    Point nP = nextPos(i, j, v, dir);

                    nextMap[nP.x][nP.y].add(new Marble(idx, v, nP.d));

                }


            }
        }

    }

    private static Point nextPos(int x, int y, int v, int dir) {

        for (int l = 0; l < v; l++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];


            if (nx < 0 || ny < 0 || nx >= n || ny >= n) { // 벽 O
                dir = 3 - dir;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }


        return new Point(x, y, dir); // 다음 위치를 전달할 임시 객체로 사용
    }


}
