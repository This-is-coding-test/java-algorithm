import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 아나그램 {
    //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String st1 = br.readLine();
//        String st2 = br.readLine();
//
//        /// 65 ~ 122 -> 122 - 65 + 1 = 58
//        int[] arr1 = new int[58];
//        int[] arr2 = new int[58];
//
//        for (int i = 0; i < st1.length(); i++) {
//            char c = st1.charAt(i);
//            char d = st2.charAt(i);
//            arr1[(int) c - 65]++;
//            arr2[(int) d - 65]++;
//        }
//
//        boolean result = true;
//        for (int i = 0; i < arr1.length; i++) {
//            if (arr1[i] != arr2[i]) {
//                result = false;
//                break;
//            }
//        }
//        System.out.println(result ? "YES" : "NO");
//
//    }
//
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st1 = br.readLine();
        String st2 = br.readLine();
        Map<Character, Integer> map = new HashMap<>();

        for (Character character : st1.toCharArray()) {
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        for (char c : st2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                System.out.println("NO");
                return;
            }
            map.put(c, map.get(c) - 1);
        }

        System.out.println("YES");
    }
}
