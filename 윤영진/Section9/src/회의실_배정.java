import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회의실_배정 {
    static class Meeting implements Comparable<Meeting>{

        private static final Comparator<Meeting> COMPARATOR =
                Comparator.comparing(Meeting::getStart);

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
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
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(start, end));

        }

        Collections.sort(meetings);

        for (int i = 0; i < N; i++) {
            int end = meetings.get(i).end;
            int size = 1;
            for (int j = i + 1; j < N; j++) {
                Meeting m = meetings.get(j);
                if (end > m.start) {
                    continue;
                }else {
                    size++;
                    end = m.end;
                }
            }

            result = Math.max(result, size);
        }
        System.out.println(result);
    }
}
