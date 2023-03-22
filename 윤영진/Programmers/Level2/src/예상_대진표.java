class 예상_대진표
{
    // 대회는 N명이 참가하고, 토너먼트 형식으로 진행
    // N명의 참가자는 각각 1부터 N번을 차례대로 배정
    // 1번 <-> 2번, ..., N - 1번 <-> N번
    // 각 게임에서 이긴 사람은 다음 라운드로 진출
    // 다음 라운드에 진출할 참가자의 번호는 다시 1번부터 N/2번을 배정

    // 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 궁금

    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(true) {
            answer++;

            a = a / 2 + a % 2; // 4 -> 2 -> 1 -> 1
            b = b / 2 + b % 2; // 7 -> 4 -> 2 -> 1
            if(a == b) break;
        }

        return answer;
    }
}