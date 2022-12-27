package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class 트로미노 {

    // n*m 크기의 이차원 영역의 각 위치에 자연수가 하나씩 적혀있다.
    // 이 때 아래의 그림에 주어진 2가지 종류의 블럭 중 한 개를 블럭이 격자를 벗어나지 않도록 적당히 올려놓아 블럭이 놓인 칸 안에 적힌 숫자의 합이 최대가 될 때의 결과를 출력

    static int n, m;
    static int[][] map;
    static int result = Integer.MIN_VALUE;
    static int[][][] shapes = new int[][][]{
            {{1, 1, 0},
                    {1, 0, 0},
                    {0, 0, 0}},

            {{1, 1, 0},
                    {0, 1, 0},
                    {0, 0, 0}},

            {{1, 0, 0},
                    {1, 1, 0},
                    {0, 0, 0}},

            {{0, 1, 0},
                    {1, 1, 0},
                    {0, 0, 0}},

            {{1, 1, 1},
                    {0, 0, 0},
                    {0, 0, 0}},

            {{1, 0, 0},
                    {1, 0, 0},
                    {1, 0, 0}},
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                result = Math.max(result, getMaxSum(i, j));
            }
        }

        System.out.println(result);
    }

    private static int getMaxSum(int x, int y) {
        int maxSum = 0;

        for (int i = 0; i < 6; i++) {
            boolean isPossible = true;
            int sum = 0;

            for (int dx = 0; dx < 3; dx++) {
                if(!isPossible) break;
                for (int dy = 0; dy < 3; dy++) {
                    if (shapes[i][dx][dy] == 0) continue;
                    if (x + dx >= n || y + dy >= m) {
                        isPossible = false;
                        break;
                    }
                    else {
                        sum += map[x + dx][y + dy];
                    }
                }
            }

            if (isPossible)
                maxSum = Math.max(maxSum, sum);

        }
        return maxSum;
    }

}
