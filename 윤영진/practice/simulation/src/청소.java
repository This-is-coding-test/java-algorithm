import java.util.*;

class 청소 {
    // 로봇은 지도의 왼쪽 가장 위 격자에서 3시 방향을 보고 있다.
    // 로봇이 한 격자를 이동하는데 1초
    // 지도 끝으로 이동해 더 이상 전진 X, 장애물인 경우 제자리에서 90도 회전 -> 회전하는데 1초
    // k초 후 로봇의 위치를 반환

    static int[] dx = {0, 1, 0, -1}; // 상, 하, 좌, 우
    static int[] dy = {1, 0, -1, 0};

    static int[][] boards;
    static int n, K;

    public int[] solution(int[][] board, int k) {
        int[] answer;
        boards = board;
        n = board.length;
        K = k;

        answer = simualte(0, 0, 0);
        return answer;
    }

    private int[] simualte(int x, int y, int dir) {
        while (K-- > 0) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!canGo(nx, ny)) {
                x = nx;
                y = ny;
            } else {
                dir = (dir + 1) % 4;
            }
        }
        return new int[]{x, y};
    }

    private boolean canGo(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n && boards[nx][ny] == 0;
    }

    public static void main(String[] args) {
        청소 T = new 청소();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}