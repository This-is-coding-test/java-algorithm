import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 학급_회장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String st = br.readLine();
        Map<Character, Integer> map = new HashMap<>();

        for (char x : st.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

//        map.containsKey('A');
//        map.getOrDefault(key, defaultValue);

        int max = Integer.MIN_VALUE;
        char answer = ' ';

        for (Character key : map.keySet()) {
            if (max < map.get(key)) {
                answer = key;
                max = map.get(key);
            }
        }
        System.out.println(answer);
    }

}
