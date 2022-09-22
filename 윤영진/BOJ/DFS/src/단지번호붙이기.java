import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 단지번호붙이기 {

    static int N;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static List<Integer> sizes = new ArrayList<>();
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    size = 1;
                    map[i][j] = 0;
                    DFS(i, j);
                    sizes.add(size);
                }
            }
        }

        System.out.println(sizes.size());
        Collections.sort(sizes);
        for (Integer s : sizes) {
            System.out.println(s);
        }

    }

    private static void DFS(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != 0) {
                map[nx][ny] = 0;
                size++;
                DFS(nx, ny);
            }


        }

    }
}
