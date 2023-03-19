package Test.Eleven;

import java.util.HashMap;
import java.util.Map;

public class Eleven1 {
    static Map<Character, Integer> map = new HashMap<>();

    public int solution(String S) {
        char[] chars = S.toCharArray();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int cnt = 0;
        for (Character key : map.keySet()) {
            if (map.get(key) % 2 != 0) cnt++;
        }
        return cnt;
    }
}
