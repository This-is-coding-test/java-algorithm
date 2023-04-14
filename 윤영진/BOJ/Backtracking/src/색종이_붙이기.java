import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_붙이기 {
    static int[][] map = new int[10][10];
    static int[] paper = new int[]{0, 5, 5, 5, 5, 5};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0, 0);
        if(result == Integer.MAX_VALUE) result = -1;
        System.out.println(result);

    }

    private static void DFS(int x, int y, int cnt) {

        if (x == 9 && y > 9) {
            result = Math.min(result, cnt);
            return;
        }
        if(result <= cnt) return;

        if (y > 9) {
            DFS(x + 1, 0, cnt);
            return;
        }

        if (map[x][y] == 1) {
            for (int i = 5; i >= 1; i--) {
                if (paper[i] > 0 && isAttach(x, y, i)) {
                    paper[i]--;
                    attach(x, y, i, 0);
                    DFS(x, y + 1, cnt + 1);
                    attach(x, y, i, 1);
                    paper[i]++;
                }
            }

        } else {
            DFS(x, y + 1, cnt);
        }

    }

    private static void attach(int x, int y, int size, int type) {
        for (int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                map[i][j] = type;
            }
        }
    }

    private static boolean isAttach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(!inRange(i, j)) return false;
                if(map[i][j] != 1) return false;
            }
        }
        return true;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < 10 && ny < 10;
    }
}
