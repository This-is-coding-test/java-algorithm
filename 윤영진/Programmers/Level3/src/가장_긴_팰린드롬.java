
class 가장_긴_팰린드롬 {
    public int solution(String s) {
        int answer = Integer.MIN_VALUE;
        for (int i = s.length(); i > 0; i--) { // 7 -> 6 -> 5
            for (int j = 0; i + j <= s.length(); j++) { // 0 -> 0 ~ 1 -> 0 ~ 2
                if (isPossible(s, j, j + i - 1)) {
                    return i;
                }
            }
        }
        return answer;
    }


    public boolean isPossible(String value, int start, int end) {

        while (start <= end) {
            if (value.charAt(start) != value.charAt(end)) return false;
            start++;
            end--;
        }
        return true;

    }
}