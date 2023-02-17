import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 배 {
    // 모든 화물은 박스 안에 넣어져 있다. 항구에는 크레인이 N대 있고, 1분에 박스를 하나씩 배에 실을 수 있다.
    // 모든 크레인은 동시에 움직인다.

    static int N, M;
    static List<Integer> cranes = new ArrayList<>();
    static List<Integer> boxes = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int w = Integer.parseInt(st.nextToken());
            cranes.add(w);
        }
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int w = Integer.parseInt(st.nextToken());
            boxes.add(w);
        }

        cranes.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if (cranes.get(0) < boxes.get(0)) {
            System.out.print(-1);
            return;
        }

        while (!boxes.isEmpty()) {
            result++;
            for (Integer crane : cranes) {
                for (int i = 0; i < boxes.size(); i++) {
                    if (crane >= boxes.get(i)) {
                        boxes.remove(i);
                        break;
                    }
                }
            }
        }


        System.out.println(result);


    }
}
