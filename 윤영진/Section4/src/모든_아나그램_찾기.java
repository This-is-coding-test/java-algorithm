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

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (Character c : T.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        int lt = 0;
        int rt = T.length() - 1;

        for (int i = 0; i < rt; i++) {
            map2.put(S.charAt(i), map2.getOrDefault(S.charAt(i), 0) + 1);
        }
        int answer = 0;
        for (int i = rt; i < S.length(); i++) {
            map2.put(S.charAt(i), map2.getOrDefault(S.charAt(i), 0) + 1);

            // answer을 통해 두 HashMap 비교가능
            if (map1.equals(map2)) {
                answer++;
            }
            map2.put(S.charAt(lt), map2.get(S.charAt(lt)) - 1);
            if (map2.get(S.charAt(lt)) == 0) {
                map2.remove(S.charAt(lt));
            }
            lt++;
        }

        System.out.println(answer);

    }


}
