import java.util.*;

class 단속카메라 {
    // 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한 번은 만나도록 카메라를 설치

    static class Point implements Comparable<Point>{
        int s;
        int e;
        public Point(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int compareTo(Point p) {
            return this.e - p.e;
        }

    }

    static List<Point> points = new ArrayList<>();

    public int solution(int[][] routes) {
        int answer = 0;
        for(int i = 0; i < routes.length; i++) {
            int s = routes[i][0];
            int e = routes[i][1];
            points.add(new Point(s, e));
        }

        Collections.sort(points);

        int cam = Integer.MIN_VALUE;
        for (Point p : points) {
            if(cam < p.s) {
                answer++;
                cam = p.e;
            }
        }

        return answer;
    }
}

