# SECTION 4. HashMap, TreeSet(해쉬, 정렬지원 Set)

## 학급 회장

```java
Map<Character, Integer> map = new Hamap.put(x, map.getOrDefault(x, 0) + 1);
        map.containsKey('A');
        shMap<>();
```

`map.put(x, map.getOrDefault(x, 0) + 1)`: map에 해당 key가 존재하면 해당 키에 대한 value를 리턴하고 없는 경우 두번째 인자로 주어진 defaultValue를 리턴하는 함수
`map.containsKey('A')`: map의 keySet 중에 인자로 주어진 key가 존재하는 경우 true를 리턴하는 함수

## 매출액의 종류

Section3에서 배운 sliding window를 사용한 문제

lt = 0, rt = K - 1로 할당한 뒤 rt에 해당하는 값(`arr[rt]`)을 Map에 넣으면서 Map의 사이즈를 통해 종류를 구해낼 수 있다.

Map과 sliding window 문제의 핵심은 `map.put(arr[left], map.get(arr[left]) - 1)` 후 `map.get(arr[left])` 값이 0인 경우 Map에서 삭제시켜주는 것이다.

## 모든 아나그램 찾기

`map1.equals(map2)` 를 통해서 두 개의 map의 entrySet이 정확히 일치하는지 비교할 수 있다.

## K번째 큰수

```java
TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
ts.remove("143");
```

처음에는 단순히 List에 값을 넣은 뒤 stream의 distinct를 통해 중복을 제거하였는데, 이런 여러과정을 함축해놓은 TreeSet이라는 함수가 있다.

`TreeSet<Integer> ts = new TreeSet<>()` 이와 같이 할당하면 오름차순으로 정렬되며 중복을 제거하는 TreeSet을 생성하고 `TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder())` 이와 같이 할당하면 내림차순으로 정렬되며 중복을 제거하는 TreeSet을 생성한다.

또한 TreeSet의 remove함수를 통해 해당 value를 삭제할 수 있다.


