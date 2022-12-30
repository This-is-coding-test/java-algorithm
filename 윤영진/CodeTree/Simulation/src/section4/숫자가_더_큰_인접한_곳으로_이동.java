package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 숫자가_더_큰_인접한_곳으로_이동 {


    static int n, r, c;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list.add(map[r][c]);
        simulate();

        for (Integer x : list) {
            System.out.print(x + " ");
        }
    }

    private static void simulate() {

        int currX = r;
        int currY = c;
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 0; i < 4; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if (nx >= 1 && ny >= 1 && nx <= n && ny <= n) {
                    if (map[nx][ny] > map[currX][currY]) {
                        flag = true;
                        currX = nx;
                        currY = ny;
                        list.add(map[currX][currY]);
                        break;
                    }
                }

            }
        }


    }
}
