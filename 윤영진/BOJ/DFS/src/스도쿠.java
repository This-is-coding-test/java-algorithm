import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스도쿠 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map = new int[9][9];
    static List<Point> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) list.add(new Point(i, j));
            }
        }

        sudoku(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static boolean sudoku(int count) {
        if (count == list.size()) {
            return true;
        } else {
            Point point = list.get(count);
            int x = point.x;
            int y = point.y;

            for (int i = 1; i < 10; i++) {
                if (isValid(x, y, i)) {
                    map[x][y] = 1;
                    if (sudoku(count + 1)) return true;
                    else map[x][y] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int x, int y, int value) {


        // 가로 확인
        // 세로 확인
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == value) return false;
            if (map[i][y] == value) return false;
        }

        // 블록 확인
        int xBlock = x / 3;
        int yBlock = y / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[(xBlock * 3) + i][(yBlock * 3) + j] == value) return false;
            }
        }

        return true;

    }
}
