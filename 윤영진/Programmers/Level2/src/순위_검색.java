import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 순위_검색 {
    Map<String, ArrayList<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String st : info) {
            String[] tmp = st.split(" ");
            make(tmp, "", 0);
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        int idx = 0;
        for (String q : query) {
            q = q.replaceAll(" and ", "");
            String[] st = q.split(" ");
            if (!map.containsKey(st[0])) {
                answer[idx] = 0;
            } else {
                answer[idx] = binarySearch(map.get(st[0]), Integer.parseInt(st[1]));
            }
            idx++;
        }

        return answer;
    }

    public void make(String[] st, String str, int depth) {
        if (depth == 4) {
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(Integer.parseInt(st[4]));
            return;
        }

        make(st, str + "-", depth + 1);
        make(st, str + st[depth], depth + 1);
    }

    public int binarySearch(ArrayList<Integer> values, int target) {

        int left = 0;
        int right = values.size() - 1;

        while (left <= right) {
            // left = 0, right = 3; -> mid = 1
            // left = 2, right = 3; -> mid = 2
            // left = 2, right = 2; -> mid = 2
            int mid = (left + right) / 2;

            if (values.get(mid) < target) left = mid + 1;
            else right = mid - 1;

        }

        return values.size() - left;

    }
}
