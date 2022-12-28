package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단_한_번의_2048_시도 {

    static int[][] map = new int[4][4];
    static String dir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dir = br.readLine();

        simulate();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static void simulate() {

        push();
        combine();
        push();




    }

    private static void combine() {

        if (dir.equals("L")) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (map[i][j] == map[i][j + 1]) {
                        map[i][j] *= 2;
                        map[i][j + 1] = 0;
                    }
                }
            }

        } else if (dir.equals("R")) {
            for (int i = 0; i < 4; i++) {
                for (int j = 3; j > 0; j--) {
                    if (map[i][j] == map[i][j - 1]) {
                        map[i][j] *= 2;
                        map[i][j - 1] = 0;
                    }
                }
            }
        } else if (dir.equals("U")) {
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 3; i++) {
                    if (map[i][j] == map[i + 1][j]) {
                        map[i][j] *= 2;
                        map[i + 1][j] = 0;
                    }
                }
            }
        } else {
            for (int j = 0; j < 4; j++) {
                for (int i = 3; i > 0; i--) {
                    if (map[i][j] == map[i - 1][j]) {
                        map[i][j] *= 2;
                        map[i - 1][j] = 0;
                    }
                }
            }
        }
    }

    private static void push() {

        int[][] temp = new int[4][4];

        if (dir.equals("L")) {
            for (int i = 0; i < 4; i++) {
                int nextCol = 0;
                for (int j = 0; j < 4; j++) {
                    if (map[i][j] > 0)
                        temp[i][nextCol++] = map[i][j];
                }
            }
        } else if (dir.equals("R")) {

            for (int i = 0; i < 4; i++) {
                int nextCol = 3;
                for (int j = 3; j >= 0; j--) {
                    if (map[i][j] > 0)
                        temp[i][nextCol--] = map[i][j];
                }
            }
        } else if (dir.equals("U")) {
            for (int j = 0; j < 4; j++) {
                int nextRow = 0;
                for (int i = 0; i < 4; i++) {
                    if (map[i][j] > 0)
                        temp[nextRow++][j] = map[i][j];
                }
            }
        } else {
            for (int j = 0; j < 4; j++) {
                int nextRow = 3;
                for (int i = 3; i >= 0; i--) {
                    if (map[i][j] > 0)
                        temp[nextRow--][j] = map[i][j];
                }
            }

        }


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j] = temp[i][j];
            }
        }


    }
}
