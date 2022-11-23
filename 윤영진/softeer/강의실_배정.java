package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실_배정 {
    // 강의실 1개에 최대한 많은 강의를 배정하려고 한다.
    // 배정된 강의는 서로 겹치지 않아야 하며 수업시간의 길이와 상관없이 최대한 많이 배정하라.
    // 두 강의의 시작시간과 종료시간은 겹쳐도 된다.
    static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Lecture{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    static int N;
    static Lecture[] lectures;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(s, e);
        }

        Arrays.sort(lectures, (o1, o2) -> {
            if (o1.end < o2.end) {
                return -1;
            } else if (o1.end == o2.end) return o1.start - o2.start;
            else {
                return 1;
            }
        });


        int prev = lectures[0].end;
        int result = 1;

        for (int i = 1; i < N; i++) {
            Lecture cur = lectures[i];

            if (cur.start >= prev){
                prev = cur.end;
                result++;
            }
        }
        System.out.println(result);


    }
}
