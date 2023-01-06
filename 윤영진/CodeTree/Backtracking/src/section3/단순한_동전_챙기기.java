package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 단순한_동전_챙기기 {

    // '.': 빈 공간, 'S': 시작점, 'E': 도착점, 1이상 9이하의 숫자
    // 숫자는 해당 위치에 동전이 놓여져 있음 -> 해당 동전의 번호
    // 이때 시작점에서 출발하여 적절하게 이동해서 최소 3개의 동전을 수집하여 도착점으로 도달
    // 동전을 수집할 시에는 꼭 번호가 증가하는 순서대로 수집
    // 해당 위치를 지나가더라도 동전을 수집하지 않아도 되며 같은 위치를 2번 이상 지나가는 것 역시 허용

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int num;

        public Point(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(Point o) {
            return this.num - o.num;
        }

        @Override
        public String toString() {
            return x + " " + y + " " + num;
        }
    }

    static int N;
    static int[][] map;
    static Point sP = new Point(-1, -1, 0);
    static Point eP = new Point(-1, -1, 0);
    static List<Point> coins = new ArrayList<>();
    static List<Point> selectedCoins = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    // 백트래킹을 이용하여 주어진 동전 중 M개의 동전을 뽑는 모든 조합을 생성
    // 각각의 조합에 대해 이동 거리를 계산

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                if (c == 'S') {
                    sP = new Point(i, j, 0);
                } else if (c == 'E') {
                    eP = new Point(i, j, 0);
                } else {
                    if (Character.isDigit(c)) {
                        coins.add(new Point(i, j, Integer.parseInt(String.valueOf(c))));
                    }
                }
            }
        }

        Collections.sort(coins);

        // 1, 2, 3, 4, 5

        backtracking(0, 0);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    private static void backtracking(int depth, int start) {
        if (depth == 3) {
            result = Math.min(result, calc());

        } else {
            for (int i = start; i < coins.size(); i++) {
                selectedCoins.add(coins.get(i));
                backtracking(depth + 1, i + 1);
                selectedCoins.remove(selectedCoins.size() - 1);
            }
        }
    }

    private static int calc() {
        int moveNum = dist(sP, selectedCoins.get(0));
        for (int i = 0; i < selectedCoins.size() - 1; i++) {
            moveNum += dist(selectedCoins.get(i), selectedCoins.get(i + 1));
        }
        moveNum += dist(selectedCoins.get(selectedCoins.size() - 1), eP);
        return moveNum;
    }

    private static int dist(Point p1, Point p2) {

        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);

    }


    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }
}
