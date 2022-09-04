import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 결혼식 {
    static class Time implements Comparable<Time>{
        private static final Comparator<Time> COMPARATOR =
                Comparator.comparing(Time::getStart)
                        .thenComparing(Time::getStage);

        int start;
        String stage;

        public Time(int start, String stage) {
            this.start = start;
            this.stage = stage;
        }

        public int getStart() {
            return start;
        }

        public String getStage() {
            return stage;
        }

        @Override
        public int compareTo(Time o) {
            return COMPARATOR.compare(this, o);
        }

    }
    static int N;
    static List<Time> times = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        int count = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            times.add(new Time(start, "S"));

            int end = Integer.parseInt(st.nextToken());
            times.add(new Time(end, "E"));
        }

        Collections.sort(times);

        for (Time time : times) {

            if (time.getStage().equals("S")) {
                count++;
            }else {
                count--;
            }

            answer = Math.max(count, answer);

        }

        System.out.println(answer);


    }
}
