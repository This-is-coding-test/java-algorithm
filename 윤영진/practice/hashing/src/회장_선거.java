import java.util.*;

class 회장_선거 {
    // 한 학생이 여러명 추천할 수 있다.
    // 추천횟수가 k번 이상인 학생들만 회장선거에 출마
    // 회장선거에 출마한 학생들은 자기를 추천해준 학생들에게 감사의 선물
    // 가장 많은 감사 선물을 받은 학생의 이름을 반환하는 프로그램
    // 답이 여러명일 경우 사전순으로 가장 빠른 이름을 반환
    // [john tom] -> john이 tom을 추천
    public String solution(String[] votes, int k) {
        HashMap<String, HashSet<String>> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>(); // 해당 후보를 찍은 사람

        for (String s : votes) {
            String[] tmp = s.split(" ");
            String s1 = tmp[0];
            String s2 = tmp[1];

            map1.putIfAbsent(s2, new HashSet<>());
            map1.get(s2).add(s1);
            // [tom {john, luis, daniel}] [luis {daniel, john}] [john {luis}]
            map2.put(s1, 0);
        }

        int max = Integer.MIN_VALUE;
        for (String key : map1.keySet()) {
            if (map1.get(key).size() >= k) {
                for (String s : map1.get(key)) {
                    map2.put(s, map2.get(s) + 1);
                    max = Math.max(max, map2.get(s));
                }
            }
        }

        ArrayList<String> results = new ArrayList<>();

        for(String key : map2.keySet()) {
            if(max == map2.get(key)) {
                results.add(key);
            }
        }
        Collections.sort(results);

        return results.get(0);
    }

    public static void main(String[] args) {
        회장_선거 T = new 회장_선거();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}