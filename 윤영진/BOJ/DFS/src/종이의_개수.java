import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 종이의_개수 {

    static int N;
    static int[][] boards;

    // 1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
    // 2. (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.

    static int gray = 0; // -1
    static int black = 0; // 0
    static int white = 0; // 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        boards = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                boards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(gray);
        System.out.println(black);
        System.out.println(white);

    }

    private static void partition(int x, int y, int size) {

        if (check(x, y, size)) {
            int color = boards[x][y];
            if (color == -1) {
                gray++;
            } else if (color == 0) {
                black++;
            } else {
                white++;
            }
            return;
        }

        int newSize = size / 3;

        partition(x, y, newSize); // 왼쪽위
        partition(x, y + newSize, newSize); // 중앙위
        partition(x, y + 2 * newSize, newSize); // 오른쪽위

        partition(x + newSize, y, newSize); // 왼쪽중앙
        partition(x + newSize, y + newSize, newSize); // 중앙중앙
        partition(x + newSize, y + 2 * newSize, newSize); // 오른쪽중앙

        partition(x + 2 * newSize, y, newSize); // 왼쪽아래
        partition(x + 2 * newSize, y + newSize, newSize); // 중앙아래
        partition(x + 2 * newSize, y + 2 * newSize, newSize); // 오른쪽아래

    }

    private static boolean check(int x, int y, int size) {

        int cur = boards[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {

                if (cur != boards[i][j]) {
                    return false;
                }

            }
        }

        return true;


    }


}
