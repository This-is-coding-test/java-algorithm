import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사탕_게임 {

    static int N;
    static char[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                change(i, j);
            }
        }

        System.out.println(answer);


    }

    private static void change(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                swap(x, y, nx, ny);
                check();
                swap(x, y, nx, ny);
            }

        }

    }

    private static void check() {
        // 행
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {

                if(map[i][j] == map[i][j-1]) {
                    count += 1;
                    answer = Math.max(answer, count);
                }
                else count =1;
            }
        }
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if(map[j][i] == map[j-1][i]) {
                    count += 1;
                    answer = Math.max(answer, count);
                }
                else count =1;
            }
        }
    }

    private static void swap(int x, int y, int nx, int ny) {
        char temp = map[x][y];
        map[x][y] = map[nx][ny];
        map[nx][ny] = temp;
    }

}
