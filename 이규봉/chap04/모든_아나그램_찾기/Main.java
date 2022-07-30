package 모든_아나그램_찾기;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public int solution(String s, String t) {
        int answer = 0;
        Map<Character, Integer> mapS = new HashMap<>();

        for (int i = 0; i < t.length() - 1; i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        /* 투 포인터 알고리즘으로 슬라이딩 윈도우 */
        int lt = 0;
        for (int rt = t.length() - 1; rt < s.length(); rt++) {
            mapS.put(s.charAt(rt), mapS.getOrDefault(s.charAt(rt), 0) + 1);
            // HashMap 의 key 와 value 비교는 equals 로
            if (mapS.equals(mapT)) {
                answer++;
            }

            mapS.put(s.charAt(lt), mapS.get(s.charAt(lt)) - 1);
            if (mapS.get(s.charAt(lt)) == 0) {
                mapS.remove(s.charAt(lt));
            }

            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();

        Main main = new Main();
        int answer = main.solution(s, t);
        System.out.println(answer);
    }

}
