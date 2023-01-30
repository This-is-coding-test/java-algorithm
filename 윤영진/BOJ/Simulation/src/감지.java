import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감지 {
    // N * M
    // 사무실에는 총 K개의 CCTV -> 5종류
    // 사무실에는 벽이 있는데, CCTV는 벽을 통과할 수 없다. / CCTV는 CCTV를 통과할 수 있다.
    // CCTV 회전 가능 -> 항상 90도 방향
    // 0은 빈 칸, 6은 벽, 1 ~ 5는 CCTV
    // 사각 지대의 최소 크기

    static class CCTV {
        int r, c, type;

        public CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }

    }

    static int N, M;
    static int[][] map;
    static List<CCTV> cctvList = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int[][][] dir = {
            {{0}}, //
            {{0}, {1}, {2}, {3}}, // 1번
            {{0, 1}, {2, 3}}, // 2번
            {{0, 3}, {3, 1}, {1, 2}, {2, 0}}, // 3번
            {{2, 0, 3}, {0, 3, 1}, {2, 1, 3}, {0, 1, 2}}, // 4번
            {{0, 1, 2, 3}} // 5번
    };

    static int result = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int remain = N * M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) cctvList.add(new CCTV(i, j, map[i][j]));
                else if (map[i][j] == 6) remain--;
            }
        }

        backtracking(0, remain - cctvList.size(), map);

        System.out.println(result);


    }

    private static void backtracking(int depth, int remain, int[][] map) {

        if (depth == cctvList.size()) {
            result = Math.min(result, remain);
        } else {
            int[][] newMap = new int[N][M];
            copy(newMap, map);

            CCTV cctv = cctvList.get(depth);

            for (int i = 0; i < dir[cctv.type].length; i++) { // 현재 CCTV 방향

                int check = 0;

                for (int k = 0; k < dir[cctv.type][i].length; k++) {
                    int d = dir[cctv.type][i][k];
                    check += observe(cctv.r, cctv.c, d, newMap);
                }

                backtracking(depth + 1, remain - check, newMap);
                copy(newMap, map);

            }


        }


    }

    private static void copy(int[][] newMap, int[][] map) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }
    }

    private static int observe(int r, int c, int d, int[][] map) {
        int cnt = 0;

        while (true) {

            r += dx[d];
            c += dy[d];

            if (!inRange(r, c) || map[r][c] == 6) return cnt;

            if ((map[r][c] >= 1 && map[r][c] <= 5) || map[r][c] == -1) continue;

            map[r][c] = -1;
            cnt++;

        }


    }

    private static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
