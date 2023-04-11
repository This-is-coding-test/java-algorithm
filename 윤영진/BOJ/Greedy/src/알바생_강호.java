import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 알바생_강호 {
    // 손님들은 자기가 커피를 몇 번째 받는지에 따라 팁을 다른 액수로 강호에게 준다.
    // 원래 주려고 했던 돈 - (받은 등수 - 1)
    // 만약 음수라면 팁을 받을 수 없다.
    // 강호가 받을 팁의 최댓값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list, Collections.reverseOrder());

        long total = 0;
        int order = 1;

        for (int i = 0; i < N; i++) {

            int p = list.get(i) - (order - 1);
            if (p > 0) total += p;
            else break;
            order++;
        }
        System.out.println(total);

    }
}
