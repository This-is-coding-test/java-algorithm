import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 응급실 {

    static class Patient {
        Integer idx;
        Integer value;

        public Patient(Integer idx, Integer value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        Integer N = Integer.parseInt(st.nextToken());
        Integer M = Integer.parseInt(st.nextToken());
        Queue<Patient> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Integer tmp = Integer.parseInt(st.nextToken());
            queue.offer(new Patient(i, tmp));
        }

        Integer count = 0;
        while (!queue.isEmpty()) {
            Boolean check = true;
            Patient tmp = queue.poll();
            for (Patient patient1 : queue) {
                if (tmp.value < patient1.value) {
                    queue.offer(tmp);
                    check = false;
                    break;
                }
            }

            if (check) {
                count++;
                if (tmp.idx == M) {
                    System.out.println(count);
                }
            }
        }
    }
}

