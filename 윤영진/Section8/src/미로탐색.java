import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로탐색 {

    static int[][] arr = new int[8][8];
    static boolean[][] ch = new boolean[8][8];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 7; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ch[1][1] = true;
        DFS(1, 1);
        System.out.println(result);


    }

    private static void DFS(int nx, int ny) {
        if (nx == 7 && ny == 7) {
            result++;
        } else {

            for (int i = 0; i < 4; i++) {

                int x = dx[i] + nx;
                int y = dy[i] + ny;

                if (x <= 7 && y <= 7 && x > 0 && y > 0 && !ch[x][y] && arr[x][y] == 0) {
                    ch[x][y] = true;
                    DFS(x, y);
                    ch[x][y] = false;

                }


            }

        }

    }
}
