package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기울어진_직사각형의_회전 {

    // 격자 내에 있는 임의의 기울어진 직사각형을 잡아 회전
    static int n;
    static int[][] grid;
    static int[][] temp;

    static int r, c, m1, m2, m3, m4, d; // r행 c열 에서 시작하여 1,2,3,4번 방향으로 각각 m1,m2,m3,m4만큼 순서대로 이동했을 때 그려지는 직사각형
    // dir 이 0인 경우에는 반시계, dir 이 1인 경우에는 시계 방향

    // Step1. temp 배열에 grid 값을 복사합니다.

    // Step2. 기울어진 직사각형의 경계를 쭉 따라가면서
    //        숫자를 한 칸씩 밀었을 때의 결과를
    //        temp에 저장합니다.

    // Step3. temp값을 grid에 옮겨줍니다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        grid = new int[n + 1][n + 1];
        temp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m1 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());
        m3 = Integer.parseInt(st.nextToken());
        m4 = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        shift(r, c, m1, m2, d);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }


    }

    // 반시계방향 -> d == 0
    // static int[] dx = {-1, -1, 1, 1};
    // static int[] dy = {1, -1, -1, 1};


    private static void shift(int x, int y, int m1, int m2, int d) {
        int[] dx;
        int[] dy;
        int[] moveNums;

        if (d == 1) { // 시계 방향
            dx = new int[]{-1, -1, 1, 1};
            dy = new int[]{-1, 1, 1, -1};
            moveNums = new int[]{m2, m1, m2, m1};
        } else {
            dx = new int[]{-1, -1, 1, 1};
            dy = new int[]{1, -1, -1, 1};
            moveNums = new int[]{m1, m2, m1, m2};
        }

        // Step1
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                temp[i][j] = grid[i][j];
            }
        }

        // Step2
        for (int dir = 0; dir < 4; dir++) {
            for (int i = 0; i < moveNums[dir]; i++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                temp[nx][ny] = grid[x][y];

                x = nx;
                y = ny;
            }
        }

        // Step3
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = temp[i][j];
            }
        }
    }
}
