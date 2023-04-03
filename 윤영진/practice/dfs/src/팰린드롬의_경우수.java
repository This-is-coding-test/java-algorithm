import java.util.*;

class 팰린드롬의_경우수 {

    Deque<Character> deque;
    HashMap<Character, Integer> map;
    int n;
    ArrayList<String> results;

    public String[] solution(String s) {
        deque = new LinkedList<>();
        results = new ArrayList<>();
        map = new HashMap<>();
        n = s.length();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int odd = 0;
        char mid = '#';
        for (Character key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                odd++;
                mid = key;
            }
        }
        if (odd > 1) return new String[]{};

        if (mid != '#') {
            deque.offer(mid);
            map.put(mid, map.get(mid) - 1);
        }

        dfs();
        String[] answer = new String[results.size()];

        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }

    private void dfs() {
        if (deque.size() == n) {
            String Ts = "";
            for (char x : deque) Ts += x;
            results.add(Ts);
        } else {
            for (Character key : map.keySet()) {
                if (map.get(key) == 0) continue;
                deque.offerFirst(key);
                deque.offerLast(key);
                map.put(key, map.get(key) - 2);
                dfs();
                deque.pollFirst();
                deque.pollLast();
                map.put(key, map.get(key) + 2);
            }
        }
    }

    public static void main(String[] args) {
        팰린드롬의_경우수 T = new 팰린드롬의_경우수();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}