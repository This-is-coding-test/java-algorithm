# SECTION 1. String(문자열)

## 문장 속 단어

```java
while((pos=s.indexOf(' '))!=-1){
    String tmp=s.substring(0,pos);
    if(max2<tmp.length()){
        max2=tmp.length();
        answer2=tmp;
    }
    s=s.substring(pos+1);
}

if(s.length()>max2)answer2=s;
```

String의 indexOf() 메소드는 매개변수로 들어온 문자가 가장 처음 발견된 인덱스를 리턴, 없는 경우 -1을 리턴

`s = "it is time to study" -> s.indexOf(' ') => 2`

String의 substring(0, pos) 메소드를 통해 문자를 자른다. -> `pos - 1까지`

String s를 substring(pos + 1)을 통해 s값을 자른 문자열을 제거하고 갱신 == (s="is time to study")

while문을 나올 때 마지막 문자인 study는 제외되므로 while문을 나오고 한번 더 검증

## 단어 뒤집기

StringBuilder의 reverse()를 통해 간단히 처리

## 특정 문자 뒤집기

left, right 변수를 이욯하여 문자열의 왼쪽 끝, 오른쪽 끝부터 left가 right를 넘어설 때까지 반복

s = "a#b!GE*T@S" -> left = 0, 1, 2, ... / right = 9(s.length() -1), 8, 7, ...

## 중복문자제거

### sol 1. stream의 distinct

입력받은 String을 toCharArray()를 통해 문자 배열로 변환하고 stream의 distinct(중복제거)를 통해 처리

### sol 2. String의 indexOf()

```java
String newStr = "";
for (int i = 0; i < st.length(); i++) {
    if (i == st.indexOf(st.charAt(i))) {
        newStr += st.charAt(i);
    }
}
```

String의 indexOf()는 해당 문자를 처음 발견한 위치를 반환하므로

st.charAt(0) = k: i = 0 -> st.indexOf(st.charAt(0)) = 0

st.charAt(1) = s: i = 1 -> st.indexOf(st.charAt(1)) = 1

st.charAt(2) = e: i = 2 -> st.indexOf(st.charAt(2)) = 2

st.charAt(3) = k: i = 3 -> st.indexOf(st.charAt(3)) = 0 ==> i != st.indexOf(st.charAt(3))

...

## 유효한 팰린드롬

입력으로 들어온 문자열(`found7, time: study; Yduts; emit, 7Dnuof`)에서 알파벳이 아닌 문자를 제거하기 위해 처음에 for문을 돌며 확인했으나 정규식을 이용하면 더 간단

```

newStr = st.toUpperCase(Locale.ROOT).replaceAll("[^A-Z]", "");
String reverseStr = new StringBuilder(newStr).reverse().toString();

```

replaceAll()의 첫 매개변수에 정규식을 넣는다. (`[^A-Z]: A ~ Z가 아닌 모든 문자`)

## 숫자만 추출

Character.isDigit()을 통해 숫자인 경우에만 새로운 문자열(`newStr`)에 append한다.

문자열이 "0208"인 경우 Integer.parseInt()를 통해 앞 0을 제거해줄 수 있다.


## 가장 짧은 문자거리

오른쪽으로 탐색, 왼쪽으로 탐색하는 for문 두개로 해결 가능

p라는 변수를 임의의 값(100보다 큰 수)으로 두고 오른쪽으로 탐색할 때 문자 t와 같지 않은 경우 p를 대입한다.

만약 탐색 중에 문자 t와 같은 경우 p를 0으로 할당한다.

왼쪽으로 탐색할 때는 기존의 값보다 p값이 작아지는 경우에만 재할당

## 암호
```java
string = string.replaceAll("[#]", "1");
string = string.replaceAll("[*]", "0");

```

replaceAll()을 통해 모든 문자 `#`을 `1`로 변경, 문자 `*`을 `0`로 변경

`Integer.parseInt(string, 2);`을 통해 문자열("1000001")을 10진수로 변경


