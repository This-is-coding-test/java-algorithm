import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이이이_풀링 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = dfs(0, 0, N);

        System.out.println(result);

    }

    private static int dfs(int x, int y, int size) {


        if (size == 2) {
            return getNum(x, y);
        } else {
            int[] arr = new int[4];
            int newSize = size / 2;

            arr[0] = dfs(x, y, newSize);
            arr[1] = dfs(x, y + newSize, newSize);
            arr[2] = dfs(x + newSize, y, newSize);
            arr[3] = dfs(x + newSize, y + newSize, newSize);

            Arrays.sort(arr);
            return arr[2];
        }
    }

    private static int getNum(int x, int y) {
        int[] arr = new int[4];
        int idx = 0;
        for (int i = x; i < x + 2; i++) {
            for (int j = y; j < y + 2; j++) {
                arr[idx++] = map[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[2];
    }
}
