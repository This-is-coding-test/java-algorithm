import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 패션왕_신해빈 {
    // 한번 입었던 옷들의 조합을 절대 다시 입지 않는다.
    // 같은 종류의 옷을 중복해서 입을 수 없기 때문에 종류별로 구분을 한 뒤 각각의 경우의 수
    // [headgear] : hat, turban
    // [eyewear] : sunglasses

    // 각각 분류된 옷에 대하여 경우의 수 -> headgear : 3가지 (안입는 경우 포함)
    // 3 x 2 - 1 (알몸 x)

    static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 1) + 1);
            }

            int result = 1;
            for (Integer value : map.values()) {
                result *= value;
            }
            sb.append(result - 1).append("\n");
        }
        System.out.println(sb);
    }

}
