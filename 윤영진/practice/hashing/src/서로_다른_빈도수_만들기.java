import java.util.*;
class 서로_다른_빈도수_만들기 {
    public int solution(String s){
        int answer = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (Character key : hashMap.keySet()) {
            while(set.contains(hashMap.get(key))) {
                answer++;
                hashMap.put(key, hashMap.get(key) - 1);
            }
            if(hashMap.get(key) == 0) continue;
            set.add(hashMap.get(key));
        }

        return answer;
    }

    public static void main(String[] args){
        서로_다른_빈도수_만들기 T = new 서로_다른_빈도수_만들기();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
