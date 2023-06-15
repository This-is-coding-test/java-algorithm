import java.util.HashMap;

public class 키패드_누르기 {
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    HashMap<Integer, Point> map = new HashMap<>();

    public String solution(int[] numbers, String hand) {
        int num = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map.put(num++, new Point(i, j));
            }
        }
        map.put(10, new Point(3, 0));
        map.put(0, new Point(3, 1));
        map.put(11, new Point(3, 2));

        int left = 10; // *
        int right = 11; // *

        StringBuilder sb = new StringBuilder();
        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7) {
                left = n;
                sb.append("L");
            } else if (n == 3 || n == 6 || n == 9) {
                right = n;
                sb.append("R");
            } else { // 2, 5, 8, 0
                int dist1 = getDist(left, n);
                int dist2 = getDist(right, n);

                if (dist1 > dist2) {
                    right = n;
                    sb.append("R");
                } else if (dist1 < dist2) {
                    left = n;
                    sb.append("L");
                } else {
                    if (hand.equals("left")) {
                        left = n;
                        sb.append("L");
                    } else {
                        right = n;
                        sb.append("R");
                    }
                }
            }
        }
        return sb.toString();
    }

    public int getDist(int start, int end) {
        Point p1 = map.get(start);
        Point p2 = map.get(end);

        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
