package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class n개의_점_중_m개_고르기 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static List<Point> points = new ArrayList<>();
    static List<Point> selectedPoints = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }

        backtracking(0, 0);
        System.out.println(result);

    }

    private static void backtracking(int depth, int start) {
        if (depth == m) {
            result = Math.min(result, getDist());
        } else {
            for (int i = start; i < n; i++) {
                selectedPoints.add(points.get(i));
                backtracking(depth + 1, i + 1);
                selectedPoints.remove(selectedPoints.size() - 1);
            }
        }

    }

    private static int getDist() {

        // 선택한 점들 중 거리가 가장 먼 두 점 사이의 거리값이 최소

        // 점 2개 선택
        int maxDist = Integer.MIN_VALUE;
        for (int i = 0; i < selectedPoints.size(); i++) {
            for (int j = i + 1; j < selectedPoints.size(); j++) {
                int dist = calc(i, j);
                if (maxDist < dist) {
                    maxDist = dist;
                }
            }
        }

        return maxDist;

    }

    private static int calc(int idx1, int idx2) {
        int x1 = selectedPoints.get(idx1).x;
        int y1 = selectedPoints.get(idx1).y;

        int x2 = selectedPoints.get(idx2).x;
        int y2 = selectedPoints.get(idx2).y;

        return (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
