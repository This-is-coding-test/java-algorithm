import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 모든_아나그램_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();



        int result = 0;

        for (int i = 0; i < S.length() - T.length() + 1; i++) {
            boolean check = true;
            Map<String, Integer> map = makeMap(T);
            for (int j = i; j < T.length() + i; j++) {
                String c = String.valueOf(S.charAt(j));
                if (map.get(c) == null) {
                    check = false;
                    break;
                }else {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) {
                        map.remove(c);
                    }
                }

            }
            if (check) {
                result++;
            }
        }
        System.out.println(result);
    }
    public static Map<String, Integer> makeMap(String T) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < T.length(); i++) {
            String c = String.valueOf(T.charAt(i));
            if (map.get(c) == null) {
                map.put(c, 1);
            }else {
                map.put(c, map.get(c) + 1);
            }
        }
        return map;

    }
}
