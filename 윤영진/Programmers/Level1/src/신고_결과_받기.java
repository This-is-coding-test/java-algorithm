import java.util.HashMap;
import java.util.HashSet;

public class 신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();

        for (String s : report) {
            String from = s.split(" ")[0];
            String to = s.split(" ")[1];
            reportMap.putIfAbsent(from, new HashSet<>());
            if (!reportMap.get(from).contains(to)) {
                countMap.put(to, countMap.getOrDefault(to, 0) + 1); // frodo 2, neo 2, muzi 1
                reportMap.get(from).add(to); // {muzi, (frodo, neo)}
            }

        }

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            if(!reportMap.containsKey(id)) {
                answer[i] = 0;
                continue;
            }
            int count = 0;
            for (String r : reportMap.get(id)) {
                if (countMap.containsKey(r) && countMap.get(r) >= k) count++;
            }
            answer[i] = count;
        }


        return answer;
    }
}
