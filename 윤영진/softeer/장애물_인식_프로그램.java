package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 장애물_인식_프로그램 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> result = new ArrayList<>();
    static int count = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    DFS(i, j);
                    result.add(count);
                }
            }
        }

        result.sort(Comparator.comparingInt(o -> o));
        System.out.println(result.size());
        result.forEach(System.out::println);


    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                if (map[nx][ny] == 1) {
                    count++;
                    DFS(nx, ny);
                }
            }
        }
    }
}
