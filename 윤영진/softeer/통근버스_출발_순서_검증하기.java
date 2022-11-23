package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 통근버스_출발_순서_검증하기 {

    // 퇴근 시간이 되면 연구소 주차장에는 수 많은 버스들이 일렬로 주차되어 있다.
    // 퇴근 버스는 번호순서 대로 출발해야 하는데, 주차장은 폭이 좁아 앞의 버스가 모두 나가야 뒤의 버스가 나갈 수 있는 구조
    // 버스를 순서에 맞게 출발시키기 위해, 연구소 주차장의 맞은편에 임시 주차장을 추가로 건설
    // 임시 주차장은 출입구가 하나밖에 없는 데다가, 폭이 좁아서 스택처럼 맨 처음 들어간 버스는 맨 마지막에 나올 수 있따.
    // 한 번 임시 주차장으로 이동했던 버스는 다시 원래의 주차장으로 이동할 수 없다.

    // 임의의 자연수 i < j < k에 대해서, ai < aj이고 aj > ak인 경우가 하나라도 있으면 정렬이 불가능하다

    // 조합 문제

    static int N;
    static int[] output;
    static int[] bus;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        output = new int[3];
        bus = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            bus[i] = Integer.parseInt(st.nextToken());
        }

        combination(0, 0);
        System.out.println(result);


    }

    private static void combination(int depth, int start) {
        if (depth == 3) {

            if (output[0] < output[1] && output[1] > output[2] && output[0] > output[2]) {
                result++;
            }

        } else {
            for (int i = start; i < N; i++) {
                    output[depth] = bus[i];
                    combination(depth + 1, i + 1);
            }
        }
    }
}
