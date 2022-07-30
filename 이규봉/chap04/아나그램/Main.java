package 아나그램;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public String solution(String str1, String str2) {
        /* 아나그램: 둘 중 한 단어를 재배열하여 다른 단어를 만들 수 있는 것 */
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return "NO";
            }
            map.put(c, map.get(c) - 1);
        }

        return "YES";

//        for (int i = 0; i < str1.length(); i++) {
//            hashMap1.put(str1.charAt(i), hashMap1.getOrDefault(str1.charAt(i), 0) + 1);
//            hashMap2.put(str2.charAt(i), hashMap2.getOrDefault(str2.charAt(i), 0) + 1);
//        }
//
//        for (char c : hashMap1.keySet()) {
//            if (!hashMap2.containsKey(c) || !hashMap2.get(c).equals(hashMap1.get(c))) {
//                return "NO";
//            }
//        }
//
//        return "YES";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        Main main = new Main();
        String answer = main.solution(str1, str2);

        System.out.println(answer);
    }

}
