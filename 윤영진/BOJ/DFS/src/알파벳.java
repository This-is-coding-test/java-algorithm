import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {
    static int R;
    static int C;

    static char[][] boards;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = Integer.MIN_VALUE;
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        boards = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                boards[i][j] = str.charAt(j);
            }
        }


        visited[boards[0][0] - 65] = true;
        DFS(1, 0, 0);

        System.out.println(result);

    }

    private static void DFS(int count, int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[boards[nx][ny] - 65]) {
                visited[boards[nx][ny] - 65] = true;
                DFS(count + 1, nx, ny);
                visited[boards[nx][ny] - 65] = false;
            }
        }
        result = Math.max(result, count);
    }
}
