import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회의실_배정 {
    static class Meeting implements Comparable<Meeting> {

        private static final Comparator<Meeting> COMPARATOR =
                Comparator.comparing(Meeting::getEnd)
                        .thenComparingInt(Meeting::getStart);

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getEnd() {
            return end;
        }

        public int getStart() {
            return start;
        }

        @Override
        public int compareTo(Meeting o) {
            return COMPARATOR.compare(this, o);
        }
    }

    static int N;
    static List<Meeting> meetings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);

        int end = 0;
        for (Meeting meeting : meetings) {
            if (meeting.start >= end) {
                end = meeting.end;
                result++;
            }
        }
        System.out.println(result);
    }
}
