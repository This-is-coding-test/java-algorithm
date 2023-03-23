class 조이스틱 {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1;


        for(int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            int up = c - 'A';
            int down = 'Z' - c + 1;
            answer += Math.min(up, down);

            int wA = i + 1;
            while(wA < len && name.charAt(wA) == 'A') {
                wA++;
            }
            // Math.min(i, len - wA) -> i : 되돌아가는 경우, len-wA : 되돌아가지 않는 경우(끝이 A)
            move = Math.min(move, i + (len - wA) + Math.min(i, len - wA));
        }

        return answer + move;
    }
}
