import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방문_길이 {


    static boolean[][][] visited = new boolean[11][11][4];
    static int[] dx = {-1, 0, 0, 1}; // 상좌우하
    static int[] dy = {0, -1, 1, 0};
    static int answer = 0;
    static int r = 5, c = 5;

    public static int solution(String dirs) {

        int[] dirMapper = new int[128];
        dirMapper['U'] = 0;
        dirMapper['L'] = 1;
        dirMapper['R'] = 2;
        dirMapper['D'] = 3;
        for (char dir : dirs.toCharArray()) {
            simulate(dirMapper[dir]);
        }
        return answer;
    }

    private static void simulate(int d) {

        int nx = r + dx[d];
        int ny = c + dy[d];

        if (!inRange(nx, ny)) return;

        if (!visited[nx][ny][d]) {
            visited[nx][ny][d] = true;
            visited[r][c][3 - d] = true;
            answer++;
        }

        r = nx;
        c = ny;

    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx <= 10 && ny <= 10;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution("UDU"));
    }
}
