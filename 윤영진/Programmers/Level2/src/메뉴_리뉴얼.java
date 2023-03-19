import java.util.*;

public class 메뉴_리뉴얼 {

    static Map<String, Integer> map = new HashMap<>();
    static List<String> answers = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {

        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = String.valueOf(chars);
        }

        for (int cLength : course) {

            for (String order : orders) {
                comb(0, "", order, cLength);
            }

            int max = Integer.MIN_VALUE;
            for (String key : map.keySet()) {
                max = Math.max(max, map.get(key));
            }

            if (max > 1) {
                for (String key : map.keySet()) {
                    if (max == map.get(key)) {
                        answers.add(key);
                    }
                }
            }
            map.clear();
        }
        Collections.sort(answers);
        String[] results = new String[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            results[i] = answers.get(i);
        }
        return results;
    }

    private void comb(int start, String val, String order, int cLength) {
        if (val.length() == cLength) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        } else {
            for (int i = start; i < order.length(); i++) {
                val += order.charAt(i);
                comb(i + 1, val, order, cLength);
                val = val.substring(0, val.length() - 1);
            }
        }

    }
}
