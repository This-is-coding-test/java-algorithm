package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 마이크로서버 {

    // 각각의 마이크로서버는 정확히 1000MiB의 메모리(RAM)를 갖고 있는데, 이 중 100MiB는 예비용으로 남겨 두기 때문에,
    // 실제로 애플리케이션들이 사용할 수 있는 메모리는 총 900MiB이다.

    // 하나의 마이크로서버에 여러 개의 마이크로서비스를 실행할 수 있는데, 이 때 마이크로서비들이 사용하는 메모리의 총합은 900MiB를 넘을 수 없다.
    // 현재 총 N개의 마이크로서비스가 실행 대기중
    // 이 중 i번째 서비스는 정확히 mi MiB의 메모리를 요구한다.
    // 각각의 서비스는 최소 300MiB, 최대 900MiB의 메모리만을 요구하고 있다.

    // 모든 마이크로서비스들을 실행하기 위해 최소 몇 대의 마이크로서버가 필요한지 구하는 프로그램을 작성

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            List<Integer> tasks = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tasks.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(tasks);

            // 300, [301, 599], 600, [601, 900] -> 4개로 분할
            // [601,900] -> 하나의 서버
            int start = 0;
            int end = N - 1;
            int servers = 0;

            // case: 601-900
            // 전체가 다 600을 넘을 수 있다.
            // 600을 넘는 케이스 모두 처리
            while (end >= start && tasks.get(end) > 600) { // 단독 서버
                servers += 1;
                end -= 1;
            }
            // case: 600
            // 300 + 600
            while (start < end && tasks.get(start) == 300 && tasks.get(end) == 600) {
                start += 1;
                end -= 1;
            }

            // 위의 케이스에서 남은 300, 600 처리
            // 단 300은 예외가 많기 때문에 300 은 일단 따로 관리
            int num300 = 0;

            while (start <= end && tasks.get(start) == 300) {
                num300++;
                start++;
            }

            // 600 처리 -> [301 ~ 600] 합쳐서 두 개씩 쌍을 지음 -> 최대 2개
            // start 입장에서 end 와 짝을 이루는게 가장 Best

            while (start < end) {
                if (tasks.get(start) + tasks.get(end) <= 900) {
                    servers += 1;
                    start++;
                    end--;
                } else if (num300 > 0) { // 900을 넘는 경우 이전에 남겨둔 300과 쌍을 맺을 수 있다.
                    servers += 1;
                    num300--;
                    end--;
                } else {
                    servers += 1;
                    end--;
                }
            }

            // 하나만 남을 수 있다.
            if (start == end) {
                servers++;
                // num300 이 남을 수 있따.
                if (num300 > 0) {
                    num300 -= 1;
                }
            }

            // 300이 남은 경우
            servers += (num300 + 2) / 3;

            System.out.println(servers);

        }
    }
}
