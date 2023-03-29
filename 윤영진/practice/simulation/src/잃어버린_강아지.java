
import java.util.*;

class 잃어버린_강아지 {
    // 지도는 항상 10 * 10
    // 0 - 빈칸, 1 - 나무, 2 - 현수, 3 - 강아지
    // 강아지와 현수는 항상 고정된 방법으로 지도를 다닌다.
    // 1. 북쪽으로 출발하되, 계속 한쪽방향으로 가다가 나무나 지도의 끝에 이르면 90도 시계방향 회전
    // 2. 한 칸을 이동하거나, 방향을 회전할 때에는 1분이 소요

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

    static int[] dx = {-1, 0, 1, 0}; // 상 ->
    static int[] dy = {0, 1, 0, -1};
    static Point hP = new Point(-1, -1, -1);
    static Point dP = new Point(-1, -1, -1);
    static int[][] boards;

    public int solution(int[][] board) {
        boards = board;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 2) {
                    hP = new Point(i, j, 0);
                } else if (board[i][j] == 3) {
                    dP = new Point(i, j, 0);
                }
            }
        }

        return simulate();
    }

    private int simulate() {
        int t = 0;
        while (t++ < 10000) {

            // 현수 이동
            int hnx = hP.x + dx[hP.d];
            int hny = hP.y + dy[hP.d];

            if (canGo(hnx, hny)) {
                hP.x = hnx;
                hP.y = hny;
            } else {
                hP.d = (hP.d + 1) % 4;
            }

            // 강아지 이동
            int dnx = dP.x + dx[dP.d];
            int dny = dP.y + dy[dP.d];

            if (canGo(dnx, dny)) {
                dP.x = dnx;
                dP.y = dny;
            } else {
                dP.d = (dP.d + 1) % 4;
            }
            // 위치 확인
            if (hP.x == dP.x && hP.y == dP.y) break;
        }

        if (t == 10000) return 0;
        return t;
    }

    private boolean canGo(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < 10 && ny < 10 && boards[nx][ny] != 1;
    }

    public static void main(String[] args) {
        잃어버린_강아지 T = new 잃어버린_강아지();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}