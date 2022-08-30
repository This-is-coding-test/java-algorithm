package 미로탐색;

import java.util.Scanner;

public class Main {
    static int[][] arr = new int[8][8];
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    static int count = 0;

    public void DFS(int x, int y) {
        if (x == 7 && y == 7) {
            count++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    DFS(nx, ny);
                    arr[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        Main main = new Main();
        arr[1][1] = 1;
        main.DFS(1, 1);
        System.out.println(count);
    }

}
