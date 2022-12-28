package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단_한_번의_2048_시도_sol {

    static int[][] map = new int[4][4];
    static char dir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dir = br.readLine().charAt(0);
        int[] dirMapper = new int[128];
        dirMapper['D'] = 0;
        dirMapper['R'] = 1;
        dirMapper['U'] = 2;
        dirMapper['L'] = 3;


        simulate(dirMapper[dir]);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static void simulate(int moveDir) {

        for(int i = 0; i < moveDir; i++)
            rotate();

        push();
        combine();
        push();

        for(int i = 0; i < 4 - moveDir; i++)
            rotate();


    }

    private static void rotate() {

        int[][] temp = new int[4][4];

        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                temp[i][j] = map[4 - j - 1][i];

        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                map[i][j] = temp[i][j];


    }

    private static void combine() {

        for (int j = 0; j < 4; j++) {
            for (int i = 3; i > 0; i--) {
                if (map[i][j] == map[i - 1][j]) {
                    map[i][j] *= 2;
                    map[i - 1][j] = 0;
                }
            }
        }

    }

    private static void push() {

        int[][] temp = new int[4][4];

        for (int j = 0; j < 4; j++) {
            int nextRow = 3;
            for (int i = 3; i >= 0; i--) {
                if (map[i][j] > 0)
                    temp[nextRow--][j] = map[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j] = temp[i][j];
            }
        }


    }
}
