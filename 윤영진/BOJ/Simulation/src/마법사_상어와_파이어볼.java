import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 마법사_상어와_파이어볼 {

    /// 마법사 상어가 크기가 N*N인 격자에 파이어볼 M개를 발사했다.
    // 가장 처음에 파이어볼은 각자 위치에서 이동을 대기하고 있다.
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Fire {
        int m;
        int d;
        int s;

        public Fire(int m, int d, int s) {

            this.m = m;
            this.d = d;
            this.s = s;
        }
    }

    static int N, M, K;
    static ArrayList<Fire>[][] map;
    static ArrayList<Fire>[][] nextMap;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N][N];
        nextMap = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nextMap[i][j] = new ArrayList<>();
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[r][c].add(new Fire(m, d, s));
        }

        while (K-- > 0) {
            simulate();
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() != 0) {
                    for (int k = 0; k < map[i][j].size(); k++) {
                        result += map[i][j].get(k).m;
                    }
                }
            }
        }
        System.out.println(result);


    }

    private static void simulate() {

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                nextMap[i][j] = new ArrayList<>();

        // 칸 이동
        moveAll();

        // Fire 합치기
        combineAndSplitFire();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = (ArrayList<Fire>) nextMap[i][j].clone();
            }
        }

    }

    private static void combineAndSplitFire() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nextMap[i][j].size() > 1) {
                    int cnt = nextMap[i][j].size();
                    int sSum = 0;
                    int mSum = 0;
                    boolean odd = true, even = true;


                    for (int k = 0; k < nextMap[i][j].size(); k++) {
                        Fire f = nextMap[i][j].get(k);
                        sSum += f.s;
                        mSum += f.m;
                        if (f.d % 2 == 0) {
                            odd = false;
                        } else {
                            even = false;
                        }
                    }

                    nextMap[i][j].clear();
                    if (mSum / 5 == 0) continue;
                    splitFire(i, j, cnt, sSum, mSum, odd , even);
                }
            }
        }


    }

    private static void splitFire(int x, int y, int cnt, int sSum, int mSum, boolean odd, boolean even) {
        if (odd | even) { // 0,2,4,6
            for (int i = 0; i < 8; i += 2) {
                nextMap[x][y].add(new Fire(mSum / 5, i, sSum / cnt));
            }
        } else {
            for (int i = 1; i <= 7; i += 2) {
                nextMap[x][y].add(new Fire(mSum / 5, i, sSum / cnt));
            }
        }
    }


    private static void moveAll() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < map[i][j].size(); k++) {
                    int m = map[i][j].get(k).m;
                    int s = map[i][j].get(k).s;
                    int dir = map[i][j].get(k).d;

                    Point nP = nextPos(i, j, s, dir);
                    nextMap[nP.x][nP.y].add(new Fire(m, dir, s));
                }
            }
        }
    }

    private static Point nextPos(int x, int y, int s, int dir) {

        for (int l = 0; l < s; l++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!inRange(nx, ny)) { // 벽
                Point p = updatePoint(nx, ny);
                nx = p.x;
                ny = p.y;
            }
            x = nx;
            y = ny;
        }

        return new Point(x, y);


    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }

    private static Point updatePoint(int nx, int ny) {

        if (nx == -1) {
            nx = N - 1;
        } else if (nx == N) {
            nx = 0;
        }

        if (ny == -1) {
            ny = N - 1;
        } else if (ny == N) {
            ny = 0;
        }

        return new Point(nx, ny);
    }
}
