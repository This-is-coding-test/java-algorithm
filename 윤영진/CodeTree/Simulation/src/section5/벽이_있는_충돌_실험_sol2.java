package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벽이_있는_충돌_실험_sol2 {

    // 격자의 특정 위치에 구슬이 존재하는 경우, 그 구슬의 방향을 해당 칸에 적어주는 것만으로 구슬의 상태를 쉽게 표현할 수 있다.
    static int T;
    static int N, M;
    static int[][] currDir;
    static int[][] nextDir;

    static int[] dx = {-1, 0, 0, 1}; // 상우좌하 -> 대칭 처리
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());


        int[] dirMapper = new int[128];
        dirMapper['U'] = 0;
        dirMapper['R'] = 1;
        dirMapper['L'] = 2;
        dirMapper['D'] = 3;


        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            currDir = new int[N + 1][N + 1];
            nextDir = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    currDir[i][j] = -1;
                }
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                char d = st.nextToken().charAt(0);

                currDir[x][y] = dirMapper[d];
            }

            for (int i = 1; i <= 2 * N; i++) {
                simulate();
            }
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (currDir[i][j] != -1) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }


    }

    private static void removeDuplicateMarbles() {

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (currDir[i][j] == -2) {
                    currDir[i][j] = -1;
                }
            }
        }

    }

    private static void simulate() {


        // Step1
        // 구슬을 전부 한 번씩 움직여 봅니다.
        moveAll();


        // Step2
        // 움직임 이후에 충돌이 일어나는 구슬들을 골라 목록에서 지워준다.
        removeDuplicateMarbles();
    }

    private static void moveAll() {


        // nextDir 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                nextDir[i][j] = -1;
            }
        }

        // (i, j) 위치에 구슬이 있는 경우
        // 움직임을 시도해보고, 그 결과를 전부 nextDir 에 기록
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (currDir[i][j] != -1) {
                    move(i, j, currDir[i][j]);
                }
            }
        }

        // nextDir 값을 currDir에 복사합니다.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                currDir[i][j] = nextDir[i][j];
            }
        }

    }

    private static void move(int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx <= 0 || ny <= 0 || nx > N || ny > N) { // 벽 O
            int newDir = 3 - dir;
            updateNextDir(x, y, newDir);
        } else {
            updateNextDir(nx, ny, dir);
        }
    }

    private static void updateNextDir(int x, int y, int dir) {

        if (nextDir[x][y] == -1) {
            nextDir[x][y] = dir;
        } else {
            nextDir[x][y] = -2; // Collide 표시
        }
    }


}
