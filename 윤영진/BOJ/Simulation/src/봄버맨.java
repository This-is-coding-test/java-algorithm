import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 봄버맨 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R, C, N;
    static char[][] map;
    static int[][] bombTime;
    // 각 칸은 비어있거나(.) / 폭탄(O)
    // 폭탄이 있는 칸은 3초가 지난 후에 폭발하고, 폭탄이 폭발한 이후에는 폭탄이 있던 칸이 파괴되어 빈 칸이 되며, 인접한 네 칸도 함꼐 파괴된다.
    //인접한 칸에 폭탄이 있는 경우에는 인접한 폭탄은 폭발 없이 파괴된다.

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        bombTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'O') {
                    bombTime[i][j] = 3;
                }
            }
        }

        int time = 0;
        while (time++ < N) {

            if (time % 2 == 0) { // 폭탄 놓음

                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombTime[i][j] = time + 3;
                        }
                    }
                }

            } else { // 폭탄 터짐

                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bombTime[i][j] == time) {
                            map[i][j] = '.';

                            for (int k = 0; k < 4; k++) {
                                int nx = i + dx[k];
                                int ny = j + dy[k];

                                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                                    if (map[nx][ny] == 'O' && bombTime[nx][ny] != time) {
                                        map[nx][ny] = '.';
                                        bombTime[nx][ny] = 0;
                                    }
                                }
                            }
                        }
                    }
                }

            }

        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }


    }
}
