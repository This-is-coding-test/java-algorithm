import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _2_1_세일 {
    // 유제품 3개를 한 번에 산다면 그 중에서 가장 싼 것을 무료로 지불

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());

        int idx = 0;
        int total = 0;
        while (idx < list.size()) {

            if (idx + 3 <= list.size()) {
                total += list.get(idx++);
                total += list.get(idx++);
                idx++;
            } else {
                while (idx < list.size()) {
                    total += list.get(idx++);
                }
            }
        }
        System.out.println(total);

    }
}
