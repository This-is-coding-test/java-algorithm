import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 디스크_컨트롤러 {

    static class Pair {
        int s1;
        int s2;

        public Pair(int s1, int s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
    }

    static PriorityQueue<Pair> pQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.s2));

    public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (Comparator.comparingInt(o -> o[0])));

        int count = 0; // 처리가 끝난 디스크
        int prev = 0; // 작업이 끝난시간
        int index = 0;

        while (count < jobs.length) {

            while (index < jobs.length && jobs[index][0] <= prev) {
                pQ.offer(new Pair(jobs[index][0], jobs[index][1]));
                index++;
            }

            if (pQ.isEmpty()) {
                prev = jobs[index][0];
            } else {
                Pair p = pQ.poll();
                answer += p.s2 + prev - p.s1;
                prev += p.s2;
                count++;
            }

        }
        return answer / jobs.length;
    }

}
