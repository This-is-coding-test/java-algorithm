package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 겹치지_않게_선분_고르기_sol {

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
    static List<Line> selectedSegs = new ArrayList<>();
    static Line[] lines;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        lines = new Line[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lines[i] = new Line(s, e);
        }

        findMaxLines(0);

        System.out.println(cnt);

    }

    private static void findMaxLines(int depth) {

        if (depth == n) {

            if (isPossible()) {
                cnt = Math.max(cnt, selectedSegs.size());
            }

        } else {

            selectedSegs.add(lines[depth]);
            findMaxLines(depth + 1);
            selectedSegs.remove(selectedSegs.size() - 1);

            findMaxLines(depth + 1);
        }
    }

    private static boolean isPossible() {

        for (int i = 0; i < selectedSegs.size(); i++) {
            for (int j = i + 1; j < selectedSegs.size(); j++) {
                if (overlapped(selectedSegs.get(i), selectedSegs.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean overlapped(Line line1, Line line2) {

        int s1 = line1.start;
        int e1 = line1.end;

        int s2 = line2.start;
        int e2 = line2.end;

        return (s1 <= s2 && s2 <= e1) || (s1 <= e2 && s2 <= e1)
                || (s2 <= s1 && s1 <= e2) || (s2 <= e1 && e1 <= e2);

    }
}
