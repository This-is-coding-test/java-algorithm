import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 보석_쇼핑 {


    public static int[] solution(String[] gems) {

        Set<String> set = new HashSet<>(Arrays.asList(gems));
        if (set.size() == 1) return new int[]{1, 1};
        int total = set.size();
        HashMap<String, Integer> map = new HashMap<>();
        int dist = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;

        int[] answer = new int[2];

        for (; right < gems.length; right++) {

            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            if (total == map.size()) {

                if (dist > right - left) {
                    dist = right - left;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }

                while (total == map.size()) {
                    map.put(gems[left], map.get(gems[left]) - 1);
                    if (map.get(gems[left]) == 0) map.remove(gems[left]);
                    left++;

                    if (total == map.size()) {
                        if (dist > right - left) {
                            dist = right - left;
                            answer[0] = left + 1;
                            answer[1] = right + 1;
                        }
                    }
                }
            }
        }


        return answer;
    }


    public static void main(String[] args) throws IOException {
        int[] solution = solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
        System.out.println(solution[0] + " " + solution[1]);
    }
}
