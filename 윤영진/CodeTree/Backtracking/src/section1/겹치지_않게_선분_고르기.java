package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 겹치지_않게_선분_고르기 {

    static class Line {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // 수직선상에 n개의 선분
    // 겹치지 않게 가장 많은 수의 선분을 고르는 프로그램
    static int n;
    static List<Line> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lines.add(new Line(s, e));
        }
        Collections.sort(lines, Comparator.comparingInt(o -> o.end));

        int end = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (end < lines.get(i).start) {
                end = lines.get(i).end;
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
