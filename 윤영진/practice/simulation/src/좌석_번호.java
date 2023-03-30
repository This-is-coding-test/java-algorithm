import java.util.*;

class 좌석_번호 {

    // c : 가로, r : 세로 -> c * r
    // (1, 1)부터 시작하여 시계방향으로 빈 좌석
    static int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
    static int[] dy = {1, 0, -1, 0};
    static int R, C;
    static boolean[][] visited;

    public int[] solution(int c, int r, int k) {
        if (k > c * r) return new int[]{0, 0};
        visited = new boolean[c + 1][r + 1];
        visited[1][1] = true;
        R = r;
        C = c;
        int x = 1;
        int y = 1;
        int d = 0;
        k -= 1;
        while (k-- > 0) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (!canGo(nx, ny)) {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            visited[nx][ny] = true;
            x = nx;
            y = ny;
        }

        return new int[]{x, y};
    }

    private boolean canGo(int nx, int ny) {
        return nx >= 1 && ny >= 1 && nx <= C && ny <= R && !visited[nx][ny];
    }

    public static void main(String[] args) {
        좌석_번호 T = new 좌석_번호();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}