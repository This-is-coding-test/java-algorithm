import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 회전_초밥 {
    // 벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
    // 각 고객에게 초밥의 종류 하나가 쓰인 쿠폰을 발행하고, 1번 행사에 참가할 경우 이 쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료 제공
    // -> 만약 이 번호에 적혀진 초밥이 현재 벨트 위에 없을 경우, 요리사가 새로 만들어 제공

    // 다양한 종류의 초밥
    static int N, d, k, c;
    static int[] sushi;
    static Map<Integer, Integer> map = new HashMap<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[N];

        for (int i = 0; i < N; i++) {
            int s = Integer.parseInt(br.readLine());
            sushi[i] = s;
        }

        for (int i = 0; i < k - 1; i++) {
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
        }

        int left = 0;

        for (int i = k - 1; i < N; i++) {
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);

            if (!map.containsKey(c)) {
                result = Math.max(result, map.size() + 1);
            } else {
                result = Math.max(result, map.size());
            }

            map.put(sushi[left], map.get(sushi[left]) - 1);
            if (map.get(sushi[left]) == 0) {
                map.remove(sushi[left]);
            }
            left++;
        }

        for (int i = 0; i < k - 1; i++) {
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
            if (!map.containsKey(c)) {
                result = Math.max(result, map.size() + 1);
            } else {
                result = Math.max(result, map.size());
            }

            map.put(sushi[left], map.get(sushi[left]) - 1);
            if (map.get(sushi[left]) == 0) {
                map.remove(sushi[left]);
            }
            left++;
        }
        System.out.println(result);
    }
}
