package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이차원_바람 {

    // N * M 행렬 모양의 건물에 총 Q번의 바람
    // 먼저 시계 방향으로 회전
    // 직사각형 영역 내에 있는 각각의 숫자들의 값이 자신과 인접한 곳에 적혀있는 숫자들과의 평균 값으로 바뀌게 된다.

    static int N, M, Q;
    static int[][] map;
    static int[][] board;

    static int r1, c1, r2, c2;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken()); // 2
            c1 = Integer.parseInt(st.nextToken()); // 2
            r2 = Integer.parseInt(st.nextToken()); // 4
            c2 = Integer.parseInt(st.nextToken()); // 6

            board = new int[N + 1][M + 1]; // [4-2][6-2] -> [2][4]

            rotate(r1, c1, r2, c2);

            setAverage(r1, c1, r2, c2);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void setAverage(int r1, int c1, int r2, int c2) {

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                board[i][j] = average(i, j);
            }
        }

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                map[i][j] = board[i][j];
            }
        }


    }

    private static int average(int x, int y) {

        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 1 && ny >= 1 && nx <= N && ny <= M) {
                sum += map[nx][ny];
                cnt++;
            }
        }
        return sum / cnt;
    }

    // Step1 직사각형 가장 왼쪽 위 모서리 값을 temp 에 저장
    // Step2 직사각형 가장 왼쪽 열 위로 한칸씩 shift
    // Step3 직사각형 가장 아래 행을 왼쪽으로 한 칸씩 shift
    // Step4 직사각형 가자 오른쪽 열을 아래로 한 칸씩 shift
    // Step5 직사각형 가장 위 행을 오른쪽으로 한 칸씩 shift
    // Step6 temp 를 가장 왼쪽 위 모서리를 기준으로 바로 오른쪽 칸에 넣는다.
    private static void rotate(int r1, int c1, int r2, int c2) {

        // Step1
        int temp = map[r1][c1];

        // Step2
        for (int i = r1; i <= r2 - 1; i++) {
            map[i][c1] = map[i + 1][c1];
        }

        // Step3
        for (int i = c1; i <= c2 - 1; i++) {
            map[r2][i] = map[r2][i + 1];
        }

        // Step4
        for (int i = r2; i > r1; i--) {
            map[i][c2] = map[i - 1][c2];
        }

        // Step5
        for (int i = c2; i > c1; i--) {
            map[r1][i] = map[r1][i - 1];
        }

        // Step6
        map[r1][c1 + 1] = temp;
    }
}
