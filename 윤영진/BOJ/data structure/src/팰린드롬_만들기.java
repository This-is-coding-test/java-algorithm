import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 팰린드롬_만들기 {
    static TreeMap<Character, Integer> map = new TreeMap<>((o1, o2) -> o2.compareTo(o1));
    static Deque<Character> deque = new LinkedList<>();
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int odd = 0;
        char mid = '#';

        for (Character key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                odd++;
                mid = key;
            }
        }

        if (odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        if (mid != '#') {
            map.put(mid, map.get(mid) - 1);
            deque.add(mid);
        }


        for (Character key : map.keySet()) {
            while (map.get(key) != 0) {
                deque.addFirst(key);
                deque.addLast(key);
                map.put(key, map.get(key) - 2);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : deque) {
            sb.append(ch);
        }
        System.out.println(sb);

    }

}
