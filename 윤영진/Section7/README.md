# SECTION 7. Recursive, Tree, Graph(DFS, BFS 기초)

## 재귀함수

재귀함수는 if ~ else 문을 통해 종료 조건을 생각하자.

예를 들어 1부터 N까지 출력하는 프로그램의 경우 N을 입력으로 받아서 N이 0이 되는 경우를 종료 조건으로 처리하면 된다.

```java
private static void recursive(int n) {
        if (n == 0) {
            return;
        }
        else {
            recursive(n - 1);
            System.out.print(n + " ");

        }
    }
```

## 피보나치 수열

피보나치는 배열과 재귀 두 가지 모두 구현해보라는 코딩인터뷰가 진행될 수 있다.

배열이 재귀보다 성능이 좋다 -> 재귀는 스택프레임으로 인해 무겁고 메모리 낭비도 심하다.

피보나치 수열은 재귀함수와 메모리제이션을 사용하면 빠르게 해결할 수 있다.

![KakaoTalk_20220822_000546849](https://user-images.githubusercontent.com/83503188/185800071-862c9818-8273-4b35-ac6e-ec6f36f4ddaf.jpg)

## 이진트리 순회(깊이우선탐색)

- 전위순회: 부모 -> 왼쪽 -> 오른쪽
- 중위순회: 왼쪽 -> 부모 -> 오른쪽
- 후위순회: 왼쪽 -> 오른쪽 -> 부모

![KakaoTalk_20220822_002226525](https://user-images.githubusercontent.com/83503188/185800074-7809374a-291c-46ef-a40c-200caa034b66.jpg)
## 부분집합 구하기(DFS)

![KakaoTalk_20220822_003408137](https://user-images.githubusercontent.com/83503188/185800076-81710c59-9d94-4acc-97e1-e073d5e45199.jpg)

```java
private static void DFS(int x) {

        if (x == N + 1) {
            for (int i = 1; i <= N; i++) {
                if (ch[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
        else {
            ch[x] = true;
            DFS(x + 1);
            ch[x] = false;
            DFS(x + 1);
        }

    }
```

## 이진트리 순회(넓이우선탐색: 레벨탐색)

BFS는 Queue를 사용하여 이진트리를 탐색한다.


```java
private static void BFS() {
        while (!queue.isEmpty()) {

            int len = queue.size();
            
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                System.out.print(node.data + " ");

                if (node.lt != null) queue.offer(node.lt);
                if (node.rt != null) queue.offer(node.rt);
            }
        }

    }
```

## 송아지 찾기(BFS : 상태트리탐색)

송아지 찾기 문제는 단순히 레벨 탐색뿐 아니라 이미 확인한 노드에 대해서 제거하는 연산이 있어야 문제가 해결된다.

![KakaoTalk_20220822_010123755](https://user-images.githubusercontent.com/83503188/185800078-5c057e90-7dc1-4326-b9eb-5716254ed4f5.jpg)

```java
private static void BFS() {

        int L = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Integer temp = queue.poll();
                if (temp == E) {
                    System.out.println(L);
                    return;
                }

                for (int move : moves) {
                    int nx = temp + move;
                    if (nx > 0 && nx <= 10000 && check[nx] == 0) {
                        check[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }

    }
```

## 그래프와 인접행렬

### 1. 무방향 그래프

```java
        // 입력
        // 5
        // 1 2
        // 1 3
        // 2 4
        // 3 4
        // 2 5

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 1
            int y = Integer.parseInt(st.nextToken()); // 2
            graph1[x][y] = 1; // graph[1][2] = 1
            graph1[y][x] = 1; // graph[2][1] = 1
        }

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if (graph1[i][j] == 1) {
                    System.out.print(j + " connect ");
                }
            }
            System.out.println();
        }
```

### 2. 방향그래프

```java
        // 입력
        // 5
        // 1 2
        // 1 3
        // 3 4
        // 4 2
        // 2 5

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 1
            int y = Integer.parseInt(st.nextToken()); // 2
            graph2[x][y] = 1; // graph[1][2] = 1
        }

        // i번 노드에서 j번 노드로 이동
        for (int i = 1; i < 6; i++) {
            System.out.print(i + " -> ");
            for (int j = 1; j < 6; j++) {
                if (graph2[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
```

### 3. 가중치 방향그래프

```java
        // 입력
        // 5
        // 1 2 2
        // 1 3 4
        // 4 2 2
        // 2 5 5
        // 3 4 5

        int L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 1
            int y = Integer.parseInt(st.nextToken()); // 2
            int w = Integer.parseInt(st.nextToken()); // 2
            graph3[x][y] = w; // graph[1][2] = 2
        }
```

## 경로 탐색(인접행렬, 인접리스트)

![KakaoTalk_20220822_205151611](https://user-images.githubusercontent.com/83503188/185916437-143aed43-b05b-4be8-93ee-43f8a6d8caef.jpg)

![KakaoTalk_20220822_210000850](https://user-images.githubusercontent.com/83503188/185916429-937e58d6-e0dd-408b-bf70-4b3ae3bbeeb2.jpg)

