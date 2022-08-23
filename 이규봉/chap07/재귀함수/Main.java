package 재귀함수;

public class Main {

    /* 재귀를 DFS로 구현 */
    public void DFS(int n) {
        // 종료 조건
        if (n == 0) {
            return;
        } else {
            // 재귀 함수는 스택 프레임을 사용한다.
            DFS(n - 1);
            // DFS(0) 까지 호출하고 종료되면 차례로(스택의 상단부터 하단으로) 출력문이 실행된다.
            // 따라서, 3 2 1 이 출력되는 것이 아닌 1 2 3 이 출력되는 것이다.
            // ex. e.printStackTrace()
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.DFS(3);
    }

}
