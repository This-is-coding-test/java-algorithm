import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최대_수입_스케쥴 {

    static class Lecture implements Comparable<Lecture> {
        private static final Comparator<Lecture> COMPARATOR =
                Comparator.comparing(Lecture::getDay);
        int pay;
        int day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        public int getDay() {
            return day;
        }

        @Override
        public int compareTo(Lecture o) {
            return COMPARATOR.compare(o, this);
        }

    }

    static int N;
    static List<Lecture> lectures = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            max = Math.max(max, day);
            lectures.add(new Lecture(pay, day));
        }
        Collections.sort(lectures);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        for (int i = max; i >= 1; i--) {
            for (; idx < N; idx++) {
                Lecture lecture = lectures.get(idx);
                if (lecture.day < i) break;
                priorityQueue.add(lecture.pay);
            }
            if (!priorityQueue.isEmpty()) answer += priorityQueue.poll();
        }

        System.out.println(answer);

    }
}
