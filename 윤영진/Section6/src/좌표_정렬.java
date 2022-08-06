import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 좌표_정렬 {

    static class Point implements Comparable<Point>{
        private static final Comparator<Point> COMPARATOR =
                Comparator.comparing(Point::getX)
                        .thenComparingInt(Point::getY);

        int x;
        int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return COMPARATOR.compare(this, o);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        List<Point> collect = points.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < N; i++) {
            Point point = collect.get(i);
            System.out.println(point.x + " " + point.y);
        }

    }
}
