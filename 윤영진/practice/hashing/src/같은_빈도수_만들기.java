import java.util.*;
class 같은_빈도수_만들기 {
    public int[] solution(String s){
        int[] answer = new int[5];
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (Character key : hashMap.keySet()) {
            max = Math.max(max, hashMap.get(key));
        }
        String tmp = "abcde";

        for (int i = 0; i < tmp.length(); i++) {
            answer[i] = max - hashMap.getOrDefault(tmp.charAt(i), 0);
        }
        return answer;
    }

    public static void main(String[] args){
        같은_빈도수_만들기 T = new 같은_빈도수_만들기();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
