import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소_회의실_개수 {
    static class Meeting implements Comparable<Meeting> {
        int time;
        boolean isStart;

        public Meeting(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
        @Override
        public int compareTo(Meeting o) {
            return this.time - o.time;
        }
    }

    static int N;
    static PriorityQueue<Meeting> pQ = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pQ.add(new Meeting(s, true));
            pQ.add(new Meeting(e, false));
        }


        int cnt = 0;
        int result = 0;
        while (!pQ.isEmpty()) {

            Meeting m = pQ.poll();
            if (m.isStart) {
                cnt++;
                result = Math.max(result, cnt);
            }else {
                cnt--;
            }
        }
        System.out.println(result);

    }
}
